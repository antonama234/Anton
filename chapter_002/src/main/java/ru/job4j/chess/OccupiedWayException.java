package ru.job4j.chess;

public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String massage) {
        super(massage);
    }
}
