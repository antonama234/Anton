package ru.job4j.list;

public class SimpleStack<T> {
    private DinamicLinkedList<T> list = new DinamicLinkedList<>();

    public SimpleStack() {
    }

    public T poll() {
        return list.delete();
    }

    public void push(T value) {
        list.add(value);
    }
}
