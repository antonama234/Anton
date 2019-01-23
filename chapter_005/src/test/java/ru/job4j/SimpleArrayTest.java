package ru.job4j;

import org.junit.Test;
import ru.job4j.generic.SimpleArray;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    @Test
    public void whenAddElement() {
        SimpleArray simpleArray = new SimpleArray(2);
        simpleArray.add("test");
        simpleArray.add("test2");
        Object rst = simpleArray.get(1);
        assertThat(rst, is("test2"));
    }

    @Test
    public void whenSetElementThenReplaceOne() {
        SimpleArray simpleArray = new SimpleArray(4);
        simpleArray.add("test");
        simpleArray.add("test2");
        simpleArray.set(1, "test3");
        assertThat(simpleArray.get(1), is("test3"));
    }

    @Test
    public void whenDeleteElementThenTwoElementsRemain() {
        SimpleArray simpleArray = new SimpleArray(3);
        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.add("test3");
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is("test3"));
    }
}
