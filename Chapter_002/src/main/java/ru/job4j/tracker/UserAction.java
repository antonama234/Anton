package ru.job4j.tracker;

import java.util.List;

public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}