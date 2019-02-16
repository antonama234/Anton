package ru.job4j.list;

public class SimpleStack<T> extends DinamicLinkedList<T>{
    private SimpleStack<T> list;

    public SimpleStack() {
        list = new SimpleStack();
    }

    public T poll() {
        return list.delete();
    }

    public void push(T value) {
        list.add(value);
    }
}
