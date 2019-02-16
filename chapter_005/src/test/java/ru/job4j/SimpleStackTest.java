package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.list.SimpleStack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    private SimpleStack<Integer> stack;

    @Before
    public void beforeTest() {
        stack = new SimpleStack<>();
    }

    @Test
    public void WhenAddTwoElementsThenHaveThoseElementsInStack() {
        stack.push(1);
        stack.push(2);
        assertThat(stack.get(1), is(1));
    }
}
