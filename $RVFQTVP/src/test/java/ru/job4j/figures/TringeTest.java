package ru.job4j.figures;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TringeTest {
    @Test
    public void whenDrawTringle() {
        Tringle tringe = new Tringle();
        String ls = System.lineSeparator();
        assertThat(
                tringe.draw(),
                is(
                        new StringBuilder()
                                .append("   X   ")
                                .append(ls)
                                .append("  XXX  ")
                                .append(ls)
                                .append(" XXXXX ")
                                .append(ls)
                                .append("XXXXXXX")
                                .toString()
                )
        );
    }
}
