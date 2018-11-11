package ru.job4j.figures;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        String ls = System.lineSeparator();
        assertThat(
            square.draw(),
            is(
                    new StringBuilder()
                            .append("XXXXX")
                            .append(ls)
                            .append("X   X")
                            .append(ls)
                            .append("X   X")
                            .append(ls)
                            .append("X   X")
                            .append(ls)
                            .append("XXXXX")
                            .toString()
            )
        );
    }
}
