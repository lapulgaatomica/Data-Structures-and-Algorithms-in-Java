package queues;

import java.util.Arrays;

public class ArrayDeque<E> implements Deque<E>{
    private static final int CAPACITY = 1000;
    private final E[] data;
    private int front = 0;
    private int size = 0;
    private int back = 0;

    public ArrayDeque(){
        this(CAPACITY);
    }

    public ArrayDeque(int capacity){
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() {
        if(isEmpty()){
            return null;
        }
        return data[front];
    }

    @Override
    public E last() {
        if(isEmpty()){
            return null;
        }
        return data[back];
    }

    @Override
    public void addFirst(E e) throws IllegalStateException{
        if(size == data.length){
            throw new IllegalStateException("Deque is full");
        }
        front = (front - 1 + data.length) % data.length;
        back = (front + size) % data.length;
        data[front] = e;
        size++;
    }

    @Override
    public void addLast(E e) throws IllegalStateException{
        if(size == data.length){
            throw new IllegalStateException("Deque is full");
        }
        back = (front + size) % data.length;
        data[back] = e;
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        E answer = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return answer;
    }

    @Override
    public E removeLast() {
        if(isEmpty()){
            return null;
        }
        E answer = data[back];
        data[back] = null;
        size--;
        back = (front + size - 1) % data.length;
        return answer;
    }

    public String toString(){
        return Arrays.toString(data);
    }
}

class main{
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(10);
        arrayDeque.addLast(5);
        System.out.println(arrayDeque);
        arrayDeque.addFirst(3);
        System.out.println(arrayDeque);
        arrayDeque.addFirst(7);
        System.out.println(arrayDeque);
        System.out.println("first == " + arrayDeque.first());
        System.out.println("remove last == " + arrayDeque.removeLast());
        System.out.println(arrayDeque);
        System.out.println("size == " + arrayDeque.size());
        System.out.println("remove last ==" + arrayDeque.removeLast());
        System.out.println("remove first == " + arrayDeque.removeFirst());
        arrayDeque.addFirst(6);
        System.out.println(arrayDeque);
        System.out.println("last == " + arrayDeque.last());
        arrayDeque.addFirst(8);
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.isEmpty());
        System.out.println("last == " + arrayDeque.last());
        System.out.println(arrayDeque);
    }
}
