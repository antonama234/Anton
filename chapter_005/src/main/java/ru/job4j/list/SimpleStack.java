package ru.job4j.list;

public class SimpleStack<T> extends DinamicLinkedList<T>{
    private DinamicLinkedList<T> list;

    public SimpleStack() {
        list = new DinamicLinkedList();
    }

    public T poll() {
        return list.delete();
    }

    public void push(T value) {
        list.add(value);
    }
}
