package ru.job4j.waitNotify;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private final Queue<T> queue;
    private int size;

    public SimpleBlockingQueue(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public void offer(T value) throws InterruptedException {
        synchronized (this.queue) {
            while (queue.size() == this.size) {
                queue.wait();
            }
            queue.add(value);
            queue.notify();
        }
    }

    public T poll() throws InterruptedException {
        synchronized (this.queue) {
            T rst = null;
            while (queue.isEmpty()) {
                queue.wait();
            }
            rst = queue.poll();
            queue.notify();
            return rst;
        }
    }
}
