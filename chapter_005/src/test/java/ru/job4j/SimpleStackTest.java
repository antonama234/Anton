package ru.job4j;

import org.junit.Test;
import ru.job4j.list.SimpleStack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    private SimpleStack<Integer> stack = new SimpleStack<>();

    @Test
    public void WhenAddTwoElementsThenHaveThoseElementsInStack() {
        stack.push(1);
        stack.push(2);
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }
}
