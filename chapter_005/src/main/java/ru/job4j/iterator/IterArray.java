package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterArray implements Iterator<Integer> {
    private final int[][] array;
    private int x = 0;
    private int y = 0;

    public IterArray(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return y < array.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int rst = array[y][x++];
        if (x == array[y].length) {
            y++;
            x = 0;
        }
        return rst;
    }
}
