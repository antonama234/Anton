package ru.job4j.wrapper;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.DinamicArray;

import java.util.Iterator;

@ThreadSafe
public class MultithreadList<E> implements Iterable {
    @GuardedBy("this")
    private DinamicArray<E> list = new DinamicArray<>(5);

    public synchronized void insert(E value) {
        list.add(value);
    }

    public synchronized E get(int index) {
        return list.get(index);
    }

    private Iterable<Object> copy(DinamicArray<E> list) {
        DinamicArray rst = new DinamicArray(5);
        for (Object value : list) {
            rst.add(value);
        }
        return rst;
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return (Iterator<E>) copy(this.list).iterator();
    }
}
