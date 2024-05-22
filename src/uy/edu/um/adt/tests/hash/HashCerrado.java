package uy.edu.um.adt.tests.hash;

import java.lang.reflect.Array;

public class HashCerrado<K,V> implements HashInt<K,V> {
    private int arraySize;
    private NodeH<K, V>[] buckets;
    private int elements;
    private float factor;

    public HashCerrado(int arraySize) {
        this.arraySize = arraySize;
        NodeH<K,V> temp = new NodeH<K,V>(null,null);
        this.buckets = (NodeH<K, V>[]) Array.newInstance(temp.getClass(), arraySize);
        this.elements = 1;
        this.factor = elements/arraySize;
    }

    public NodeH<K, V>[] getBuckets() {
        return buckets;
    }

    public int getArraySize() {
        return arraySize;
    }

    public int getElements() {
        return elements;
    }

    public float getFactor() {
        return factor;
    }

    private int hashFunc(K key) {
        return key.hashCode() % arraySize;
    }

    @Override
    public void put(K key, V value) {

        boolean insertado = false;
        elements += 1;
        NodeH<K, V> newNode = new NodeH<>(key, value);
        this.factor = elements / this.arraySize;
        if (factor <= 0.8) {
            int index = hashFunc(key);
            for (int i = index; i < buckets.length; i++) {
                if (buckets[i] == null && !insertado) {
                    buckets[i] = newNode;
                    insertado = true;
                }
            }
            if (!insertado) {
                for (int i = 0; i < index-1; i++) {
                    if (buckets[i] == null && !insertado) {
                        buckets[i] = newNode;
                        insertado = true;
                    }
                }
            }
        } else {
            int newSize = this.arraySize*2;
            NodeH<K, V>[] tempArray = this.buckets;
            this.buckets = (NodeH<K, V>[]) Array.newInstance(newNode.getClass(), newSize);
            this.elements = 0;
            this.arraySize = newSize;
            for(NodeH<K, V> node : tempArray) {
                if (node != null) {
                    put(node.getKey(), node.getValue());
                }
            }
            this.put(key, value);
        }
    }

    @Override
    public boolean contains(K key) {
        if (this.get(key) != null){
            return true;
        }
        return false;
    }

    @Override
    public void remove(K key) throws NoPerteneceException{
        int index = hashFunc(key);
        if(buckets[index] != null){
        buckets[index] = null;
        elements-=1;
        factor = elements/this.arraySize;
        }
        else {
            throw new NoPerteneceException();
        }
    }

    private V get(K key) {
        int index = hashFunc(key);
        if (buckets[index] != null) {
            NodeH<K, V> current = buckets[index];
            if (current.getKey().equals(key)) {
                return current.value;
            }
        }
        return null;
    }
}