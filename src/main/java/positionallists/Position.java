package positionallists;

public interface Position<E> {
    E getElement() throws IllegalStateException;
}
