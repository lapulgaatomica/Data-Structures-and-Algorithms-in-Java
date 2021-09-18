package queues;

public interface CircularQueue<E> extends Queue<E> {
    void rotate();
}
