package uy.edu.um.adt.tests.hash;

public interface HashInt<K,V> {
    public void put(K key, V value);
    public boolean contains(K key);
    public void remove(K clave) throws NoPerteneceException;
}

