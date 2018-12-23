package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import java.util.stream.IntStream;

public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("Фигура не найдена!");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        for (Cell step : steps) {
            if (this.findBy(step) != -1) {
                throw new OccupiedWayException("Клетка занята!");
            }
        }
        if (steps.length > 0) {
            this.figures[index] = this.figures[index].copy(dest);
            rst = true;
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        return IntStream.range(0, figures.length).filter(index -> figures[index].equals(cell)).findFirst().orElse(rst);
    }
}
