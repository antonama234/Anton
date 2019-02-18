package ru.job4j;

import org.junit.Test;
import ru.job4j.list.DinamicLinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DinamicLinkedListTest {
    private DinamicLinkedList<Integer> list = new DinamicLinkedList<>();

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        list.add(1);
        list.add(2);
        assertThat(list.get(1), is(1));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIterateNextThenHaveException() {
        list.add(1);
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
        list.add(1);
        iterator.next();
    }
}
