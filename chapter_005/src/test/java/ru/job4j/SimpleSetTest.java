package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.set.SimpleSet;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    private SimpleSet<Integer> simpleSet;

    @Before
    public void before() {
        simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
    }

    @Test
    public void whenReturnFirstElement() {
        Iterator<Integer> it = simpleSet.iterator();
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenAddOneDuplicateElementThenFalse() {
        assertThat(simpleSet.add(1), is(false));
    }
}
