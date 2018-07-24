package ru.job4j.figures;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        String ls = System.lineSeparator();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
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
                                .append(ls)
                                .toString()
                )
        );
        System.setOut(stdout);
    }
}
