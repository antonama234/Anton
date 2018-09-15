package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (source.y == dest.y + 1 && source.x == dest.x + 1 || source.y == dest.y + 2 && source.x == dest.x + 2 ||
                source.y == dest.y + 3 && source.x == dest.x + 3 || source.y == dest.y + 4 && source.x == dest.x + 4 ||
                source.y == dest.y + 5 && source.x == dest.x + 5 || source.y == dest.y + 6 && source.x == dest.x + 6 ||
                source.y == dest.y + 7 && source.x == dest.x + 7 || source.y == dest.y - 1 && source.x == dest.x - 1 ||
                source.y == dest.y - 2 && source.x == dest.x - 2 || source.y == dest.y - 3 && source.x == dest.x - 3 ||
                source.y == dest.y - 4 && source.x == dest.x - 4 || source.y == dest.y - 5 && source.x == dest.x - 5 ||
                source.y == dest.y - 6 && source.x == dest.x - 6 || source.y == dest.y - 7 && source.x == dest.x - 7 ||
                source.y == dest.y + 1 && source.x == dest.x - 1 || source.y == dest.y + 2 && source.x == dest.x - 2 ||
                source.y == dest.y + 3 && source.x == dest.x - 3 || source.y == dest.y + 4 && source.x == dest.x - 4 ||
                source.y == dest.y + 5 && source.x == dest.x - 5 || source.y == dest.y + 6 && source.x == dest.x - 6 ||
                source.y == dest.y + 7 && source.x == dest.x - 7 || source.y == dest.y - 1 && source.x == dest.x + 1 ||
                source.y == dest.y - 2 && source.x == dest.x + 2 || source.y == dest.y - 3 && source.x == dest.x + 3 ||
                source.y == dest.y - 4 && source.x == dest.x + 4 || source.y == dest.y - 5 && source.x == dest.x + 5 ||
                source.y == dest.y - 6 && source.x == dest.x + 6 || source.y == dest.y - 7 && source.x == dest.x + 7) {
            steps = new Cell[] { dest };
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
