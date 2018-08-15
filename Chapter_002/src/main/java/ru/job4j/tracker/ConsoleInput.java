package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int res = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == res) {
                exist = true;
                break;
            }
        }

        if (exist) {
            return res;
        } else {
            throw new MenuOutException("Введите верный пунк меню.");
        }
    }
}
