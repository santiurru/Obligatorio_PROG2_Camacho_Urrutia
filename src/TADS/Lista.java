package TADS;

public interface Lista<T extends Comparable<T>> {
    void remove(int position) throws WrongPositionException;
    Object get(int position);
    public void addLast(T value);
}
