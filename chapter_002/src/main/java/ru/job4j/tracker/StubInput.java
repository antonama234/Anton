package ru.job4j.tracker;

import java.util.List;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int res = Integer.valueOf(this.ask(question));
        return res;
    }
}