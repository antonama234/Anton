package ru.job4j.chess;

public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String massage) {
        super(massage);
    }
}
