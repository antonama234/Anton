package ru.job4j;

import org.junit.Test;
import ru.job4j.list.Node;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NodeTest {
    @Test
    public void whenHaveFourElementsThenFourthLinkToFirst() {
        Node<Integer> first = new Node(1);
        Node<Integer> second = new Node(2);
        Node<Integer> third = new Node(3);
        Node<Integer> fourth = new Node(4);

        first.getNext(second);
        second.getNext(third);
        third.getNext(fourth);
        fourth.getNext(first);
        assertThat(first.hasCycle(second), is(true));
    }
}
