package ru.job4j.map;

import java.util.Iterator;

public class SimpleHashMap<K, V> implements Iterable {
    private DataItem[] simpleArray;
    private int arraySize;
    private int elements = 0;

    public SimpleHashMap(int size) {
        simpleArray = new DataItem[size];
        arraySize = size;
    }

    public int hash(K key) {
        int hash = key.hashCode();
        return hash % arraySize;
    }

    public void insert(K key, V value) {
        int hashVal = hash(key);
        while (simpleArray[hashVal] != null) {
            ++hashVal;
        }
        simpleArray[hashVal] = new DataItem(key, value);
        elements++;
    }

    public V get(K key) {
        int hashVal = hash(key);
        if (simpleArray[hashVal] != null) {
            return (V) simpleArray[hashVal].getValue();
        } else {
            return null;
        }
    }

    public boolean delete(K key) {
        boolean rst = false;
        int hashVal = hash(key);
        if (simpleArray[hashVal].getKey() == key) {
            simpleArray[hashVal] = null;
            rst = true;
            elements--;
            }
        return rst;
    }

    public int getElements() {
        return elements;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int position;

            @Override
            public boolean hasNext() {
                return position < arraySize;
            }

            @Override
            public Object next() {
                for (int i = position; i < arraySize; i++) {
                    if (simpleArray[i] != null){
                        position = i++;
                        return simpleArray[i];
                    }
                }
                return null;
            }
        };
    }
}

