package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<Task>();

    public void put(Task task) {
        for (Task index : tasks) {
            if (index.getPriority() == 1) {
                this.tasks.addFirst(task);
            }
        }
    }

    public Task take() {
            return this.tasks.poll();
    }
}
