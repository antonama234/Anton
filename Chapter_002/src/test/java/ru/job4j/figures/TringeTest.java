package ru.job4j.figures;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TringeTest {
    @Test
    public void whenDrawTringle() {
        Tringle tringe = new Tringle();
        assertThat(
                tringe.draw(),
                is(
                        new StringBuilder()
                                .append("   X   " + "\n")
                                .append("  XXX  " + "\n")
                                .append(" XXXXX " + "\n")
                                .append("XXXXXXX")
                                .toString()
                )
        );
    }
}
