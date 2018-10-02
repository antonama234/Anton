package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.BishopBlack;

public class ChessTest {
    @Test
    public void test() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Cell[] actual = bishop.way(bishop.position(), Cell.H8);
        Cell[] expected = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        assertThat(actual, is(expected));
    }


    @Test
    public void test1() {
        BishopBlack bishop = new BishopBlack(Cell.G8);
        Cell[] actual = bishop.way(bishop.position(), Cell.A2);
        Cell[] expected = {Cell.F7, Cell.E6, Cell.D5, Cell.C4, Cell.B3, Cell.A2};
        assertThat(actual, is(expected));
    }

    @Test
    public void test2() {
        BishopBlack bishop = new BishopBlack(Cell.A3);
        Cell[] actual = bishop.way(bishop.position(), Cell.C1);
        Cell[] expected = {Cell.B2, Cell.C1};
        assertThat(actual, is(expected));
    }

    @Test
    public void test3() {
        BishopBlack bishop = new BishopBlack(Cell.F1);
        Cell[] actual = bishop.way(bishop.position(), Cell.A6);
        Cell[] expected = {Cell.E2, Cell.D3, Cell.C4, Cell.B5, Cell.A6};
        assertThat(actual, is(expected));
    }
}