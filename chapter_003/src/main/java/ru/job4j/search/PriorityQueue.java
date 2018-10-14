package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<Task>();

    public void put(Task task) {
        for (Task index : tasks) {
            if (tasks.isEmpty()) {
                this.tasks.add(task);
            } else if (task.getPriority() > index.getPriority()) {
                this.tasks.add(index.getPriority(), task);
                break;
            }
        }
    }

    public Task take() {
            return this.tasks.poll();
    }
}
