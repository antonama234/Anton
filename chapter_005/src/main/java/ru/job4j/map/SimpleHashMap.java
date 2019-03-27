package ru.job4j.map;

import java.util.Iterator;

public class SimpleHashMap<K, V> implements Iterable {
    private DataItem[] simpleArray;
    private int arraySize;
    private int elements;

    public SimpleHashMap(int size) {
        simpleArray = new DataItem[size];
        arraySize = size;
    }

    public int hash(K key) {
        int hash = key.hashCode();
        return hash % arraySize;
    }

    public boolean insert(K key, V value) {
        boolean rst = false;
        int hashVal = hash(key);
        if (simpleArray[hashVal] == null) {
            simpleArray[hashVal] = new DataItem(key, value);
            elements++;
            resize();
            rst = true;
        }
        return rst;
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

    public void resize() {
        if (elements == arraySize) {
            DataItem[] newSimpleArray = new DataItem[arraySize*2];
            for (DataItem<K, V> item : simpleArray) {
                if (item != null) {
                    newSimpleArray[hash(item.getKey())] = item;
                }
            }
            simpleArray = newSimpleArray;
        }
    }

    public int getElements() {
        return elements;
    }

    public int getArraySize() {
        return arraySize;
    }

    public static class DataItem<K, V> {
        private K key;
        private V value;

        public DataItem(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
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

