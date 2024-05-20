package adt.linkedlist;

public interface MyList<T> {

    void add(T value);

    T get(int position);

    boolean contains(T value);

    void remove(T value);

    int size();

    Node<T> getPrimero();

    void recorro_recu(Node<T> primero);
}
