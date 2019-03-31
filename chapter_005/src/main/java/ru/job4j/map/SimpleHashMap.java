package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable {
    private DataItem[] simpleArray;
    private int elements;
    private double capacity = 0.75;
    private int modCount;

    public SimpleHashMap(int size) {
        simpleArray = new DataItem[size];
    }

    public int hash(K key) {
        int hash = key.hashCode();
        return hash % (simpleArray.length - 1);
    }

    public boolean insert(K key, V value) {
        boolean rst = false;
        int hashVal = hash(key);
        if (simpleArray[hashVal] == null) {
            simpleArray[hashVal] = new DataItem(key, value);
            elements++;
            modCount++;
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
            modCount++;
            }
        return rst;
    }

    public void resize() {
        if (elements >= simpleArray.length*capacity) {
            DataItem[] newSimpleArray = new DataItem[simpleArray.length*2];
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
        return simpleArray.length;
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
            private int expectModCount = modCount;

            @Override
            public boolean hasNext() {
                if (this.expectModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return position < simpleArray.length;
            }

            @Override
            public Object next() {
                if (this.expectModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                for (int i = position; i < simpleArray.length; i++) {
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

