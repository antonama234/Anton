package ru.job4j.tracker;

import java.util.List;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Введен некорректный пунк меню.");
            } catch (NumberFormatException nfe) {
                System.out.println("Введен некорректный формат пункта меню.");
            }
        } while (invalid);
        return value;
    }
}
