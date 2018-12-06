package ru.job4j;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FunctionsTest {
    @Test
    public void whenIncreaseOnOne() {
        Functions functions = new Functions();
        List<Double> rst = functions.line(1, 6);
        List<Double> expected = Arrays.asList(1D, 2D, 3D, 4D, 5D);
        assertThat(rst, is(expected));
    }

    @Test
    public void whenMultipleOnTwo() {
        Functions functions = new Functions();
        List<Double> rst = functions.quadratic(1, 4);
        List<Double> expected = Arrays.asList(1D, 8D, 27D);
        assertThat(rst, is(expected));
    }

    @Test
    public void whenssSd() {
        Functions functions = new Functions();
        List<Double> rst = functions.logarithmic(1, 4);
        List<Double> expected = Arrays.asList(Math.log(1.0), Math.log(2.0), Math.log(3.0));
        assertThat(rst, is(expected));
    }
}
