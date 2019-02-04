package ru.job4j;

import org.junit.Test;
import ru.job4j.list.DinamicArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DinamicArrayTest {
    DinamicArray<Integer> dinamicArray = new DinamicArray<>(3);

    @Test
    public void whenAddElementThenHaveANewOneAndGetIt() {
        dinamicArray.add(1);
        dinamicArray.add(2);
        assertThat(dinamicArray.get(0), is(1));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIterateNextThenHaveException() {
        dinamicArray.add(1);
        dinamicArray.add(2);
        Iterator iterator = dinamicArray.iterator();
        assertThat(iterator.next(), is(1));
        dinamicArray.add(3);
        iterator.next();
    }
}
