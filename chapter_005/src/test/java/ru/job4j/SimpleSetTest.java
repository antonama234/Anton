package ru.job4j;

import org.junit.Test;
import ru.job4j.set.SimpleSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    private SimpleSet<Integer> simpleSet = new SimpleSet<>(3);

    @Test
    public void whenAddElementThenHaveANewOneAndGetIt() {
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
        assertThat(simpleSet.get(2), is(3));
        assertThat(simpleSet.getSize(), is(3));
    }
}
