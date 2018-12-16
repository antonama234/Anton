package ru.job4j.search;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        if (tasks.isEmpty()) {
            this.tasks.add(task);
        }
        IntStream.range(0, tasks.size())
                .filter(i -> tasks.get(i).getPriority() > task.getPriority())
                .findFirst().ifPresent(i -> tasks.add(i, task));
    }

    public Task take() {
            return this.tasks.poll();
    }
}
