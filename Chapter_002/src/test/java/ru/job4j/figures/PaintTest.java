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
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("XXXXX" + "\n")
                                .append("X   X" + "\n")
                                .append("X   X" + "\n")
                                .append("X   X" + "\n")
                                .append("XXXXX" + "\r\n")
                                .toString()
                )
        );
        System.setOut(stdout);
    }
}
