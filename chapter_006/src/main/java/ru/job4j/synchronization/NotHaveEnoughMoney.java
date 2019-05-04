package ru.job4j.synchronization;

public class NotHaveEnoughMoney extends RuntimeException {
    public NotHaveEnoughMoney(String message) {
        super(message);
    }
}
