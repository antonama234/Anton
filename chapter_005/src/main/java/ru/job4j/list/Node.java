package ru.job4j.list;

public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public void getNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasCycle(Node first) {
        Node firstNode = first;
        Node secondNode = first;

        while (secondNode != null && secondNode.next != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next.next;
            if (firstNode == secondNode) {
                return true;
            }
        }
        return false;
    }
}
