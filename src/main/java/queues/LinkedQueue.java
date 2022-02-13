package queues;

import fundamentaldatastructures.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E> {

    private final SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedQueue(){}

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
