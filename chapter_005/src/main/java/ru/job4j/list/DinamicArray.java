package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicArray<E> implements Iterable<E> {
    private Object[] container;
    private int size;
    private int modCount;

    public DinamicArray(int size) {
        this.container = new Object[size];
    }

    public void add(E value) {
        modCount++;
        this.container[size++] = value;
    }

    public E get(int index) {
        return (E) this.container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int position;
            int expectedModCount =  modCount;
            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return position < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[position++];
            }
        };
    }
}

