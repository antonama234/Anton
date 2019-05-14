package ru.job4j;

import org.junit.Test;
import ru.job4j.wrapper.MultithreadList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultithreadListTest {
    @Test
    public void whenChangeAfterIteration() {
        MultithreadList<Integer> list = new MultithreadList<>();
        list.insert(1);
        Iterator<Integer> iterator = list.iterator();
        list.insert(2);
        assertThat(iterator.next(), is(list.get(0)));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIterateNextThenHaveException() {
        MultithreadList<Integer> list = new MultithreadList<>();
        list.insert(1);
        list.insert(2);
        Iterator iterator = list.iterator();
        assertThat(iterator.next(), is(1));
        list.insert(3);
        iterator.next();
    }
}
