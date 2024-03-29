package queues;

import fundamentaldatastructures.CircularlyLinkedList;

public class LinkedCircularQueue<E> implements CircularQueue<E> {

    private final CircularlyLinkedList<E> list = new CircularlyLinkedList<>();

    public LinkedCircularQueue(){}

    public void rotate() {
        list.rotate();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E first() {
        return list.first();
    }

    public E dequeue() {
        return list.removeFirst();
    }
}
