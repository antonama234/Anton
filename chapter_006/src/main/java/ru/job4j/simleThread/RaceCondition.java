package ru.job4j.simleThread;

/**
 * Состояние гонки возникает тогда, когда несколько потоков многопоточного приложения пытаются одновременно получить
 * доступ к данным, причем хотя бы один поток выполняет запись. Как видно, пока присваивалось newValue что-то пошло не
 * так и newValue стало больше. Какой-то из потоков в состоянии гонки успел изменить value между этими двумя командам.
 * Как мы видим, проявилась гонка между потоками.
 */

public class RaceCondition {
    public static int value = 0;

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                int oldValue = value;
                int newValue = ++value;
                if (oldValue + 1 != newValue) {
                    throw new IllegalStateException(oldValue + " + 1 = " + newValue);
                }
            }
        };
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
