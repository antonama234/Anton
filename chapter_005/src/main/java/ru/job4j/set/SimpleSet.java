package ru.job4j.set;

import ru.job4j.list.DinamicArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private DinamicArray<E> array = new DinamicArray<>(5);

    public boolean add(E e) {
        boolean rst = false;
        if (findDuplicate(e)) {
            this.array.add(e);
            rst = true;
        }
        return rst;
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

    @Override
    public Iterator<E> iterator() {
        return this.array.iterator();
    }
}
