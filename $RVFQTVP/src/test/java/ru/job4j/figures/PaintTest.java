package ru.job4j.figures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("XXXXX")
                                .add("X   X")
                                .add("X   X")
                                .add("X   X")
                                .add("XXXXX")
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Tringle());
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   X   ")
                                .add("  XXX  ")
                                .add(" XXXXX ")
                                .add("XXXXXXX")
                                .toString()
                )
        );
    }
}
