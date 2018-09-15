package ru.job4j.chess.figures.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
        int deltaX = Integer.compare(source.x, dest.x);
        int deltaY = Integer.compare(source.y, dest.y);
        int nextStepX = source.x + deltaX;
        int nextStepY = source.y + deltaY;
        if () {
            throw new ImpossibleMoveException("Слон так не ходит.");
        }
        for (int index = 0; index < Cell.values().length; index++) {
            if (deltaX == deltaY || deltaX == -deltaY || -deltaX == deltaY || -deltaX == -deltaY) {
                steps[index] = new Cell[] {dest};
            }
        }
       return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
