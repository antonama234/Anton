package ru.job4j.set;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private Object[] array;
    private int size;

    public SimpleSet(int size) {
        this.array = new Object[size];
    }

    public void add(E e) {
        findDuplicate(e);
        this.array[size++] = e;
    }

   public boolean findDuplicate(E e) {
        boolean rst = true;
        for (Object value : array) {
            if (value.equals(e)) {
                rst = false;
            }
        }
        return rst;
    }

    public E get(int index) {
        return (E) this.array[index];
    }

    public int getSize() {
        return array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int position;
             @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public E next() {
                return (E) array[position++];
            }
        };
    }
}
