package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> iterator = it.next();
            @Override
            public boolean hasNext() {
                while (iterator != null && !iterator.hasNext()) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    iterator = it.next();
                }
                return true;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    return iterator.next();
                }
            }
        };
    }
}
