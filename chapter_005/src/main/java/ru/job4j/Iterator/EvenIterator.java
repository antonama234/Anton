package ru.job4j.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] array;
    private int index = 0;

    public EvenIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean rst = false;
            if (array.length > 1) {
                for (int i = index; i != array.length; i++) {
                    if (array[index] % 2 == 0) {
                        rst = true;
                        break;
                    }
                    index++;
                }
            }
        return rst;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }
}
