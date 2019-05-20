package ru.job4j;

import org.junit.Test;
import ru.job4j.waitNotify.SimpleBlockingQueue;

public class SimpleBlockingQueueTest {
    private final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(3);

    @Test
    public void whenQueueIsFullThenWait() throws InterruptedException {
        Thread producer = new Thread(() -> {
            try {
                queue.offer(1);
                queue.offer(2);
                queue.offer(3);
                queue.offer(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread customer = new Thread(() -> {
            try {
                queue.poll();
                queue.poll();
                queue.poll();
                queue.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();
        customer.start();
        producer.join();
        customer.join();
    }
}
