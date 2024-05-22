package uy.edu.um.adt.tests.hash;

public class NodeH<K,V> {
    K key;

    V value;

    public NodeH(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        NodeH<K,V> temp = (NodeH<K, V>) o;
        return temp.getKey().equals(this.key);
    }

}
