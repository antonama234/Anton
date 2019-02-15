package ru.job4j.list;

public class SimpleStack<T> {
    private SimpleStack list;
    private Node<T> first;

    public SimpleStack() {
        list = new SimpleStack();
    }

    public void add(T value) {
        Node<T> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
    }

    public T delete() {
        Node<T> temp = first;
        this.first = first.next;
        return temp.date;
    }

    public T poll() {
        return (T) list.delete();
    }

    public void push(T value) {
        list.add(value);
    }

    private static class Node<T> {
        T date;
        Node<T> next;

        Node(T date) {
            this.date = date;
        }
    }
}
