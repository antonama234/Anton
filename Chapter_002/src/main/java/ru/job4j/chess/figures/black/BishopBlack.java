package ru.job4j.chess.figures.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rst = false;
        if (Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y)) {
            rst = true;
        }
        return rst;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Слон так не ходит!");
        }
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);
        int stepX = source.x;
        int stepY = source.y;
            for (int index = 0; index <steps.length; index++) {
                stepX += deltaX;
                stepY += deltaY;
                steps[index] = Cell.find(stepX, stepY);
            }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
