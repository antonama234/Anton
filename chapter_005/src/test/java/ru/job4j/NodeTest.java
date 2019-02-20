package ru.job4j;

import org.junit.Test;
import ru.job4j.list.Node;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NodeTest {
    @Test
    public void whenHaveFourElementsThenFourthLinkToFirst() {
        Node<Integer> first = new Node(1);
        Node<Integer> two = new Node(2);
        Node<Integer> third = new Node(3);
        Node<Integer> four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(first.hasCycle(first), is(true));
    }
}
