package ru.job4j.Generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    Object[] objects;
    private int position = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        if (position > objects.length) {
            throw new IndexOutOfBoundsException();
        } else {
            this.objects[this.position++] = model;
        }
    }

    public void set(int index, T model) {
        objects[index] = model;
    }

    public void remove(int index) {
        if (index >= 0 && index < objects.length) {
            System.arraycopy (objects, index + 1, objects, index, objects.length - 1 - index);
        }
    }

    public T get(int position) {
        return (T) this.objects[position];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;
            @Override
            public boolean hasNext() {
                return position < objects.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[position++];
            }
        };
    }
}
