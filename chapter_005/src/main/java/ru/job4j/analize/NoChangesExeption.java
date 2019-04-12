package ru.job4j.analize;

public class NoChangesExeption extends RuntimeException {
    public NoChangesExeption(String massage) {
        super(massage);
    }
}
