package ru.job4j.list;

public class SimpleQueue<T> {
    private DinamicLinkedList<T> list = new DinamicLinkedList<>();

    public SimpleQueue() {
    }

    public T poll() {
        return list.delete();
    }

    public void push(T value) {
        list.addLast(value);
    }
}
