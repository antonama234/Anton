package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenPriorityUrgent1() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("lowest", 5));
        queue.put(new Task("urgent_1", 1));
        queue.put(new Task("lower", 4));
        queue.put(new Task("urgent_2", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent_3", 1));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent_1"));
    }
}
