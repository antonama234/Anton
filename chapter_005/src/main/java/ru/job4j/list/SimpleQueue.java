package ru.job4j.list;

public class SimpleQueue<T> {
    SimpleStack<T> input = new SimpleStack<>();
    SimpleStack<T> output = new SimpleStack<>();

    public T poll() {
        if (output.isEmpty()) {
            if (input.isEmpty()) {
                throw new NullPointerException();
            }
            while (!input.isEmpty()) {
                output.push(input.poll());
            }
        }
        return output.poll();
    }

    public void push(T value) {
        input.push(value);
    }
}
