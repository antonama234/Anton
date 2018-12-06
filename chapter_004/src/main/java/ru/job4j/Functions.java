package ru.job4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Functions {

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int index = start; index != end; index++) {
            list.add(func.apply(new Double(index)));
        }
        return list;
    }

    public List<Double> line(int start, int end) {
        return diapason(start, end, i -> i);
    }

    public List<Double> quadratic(int start, int end) {
        return diapason(start, end, i -> Math.pow(i, 3.0));
    }

    public List<Double> logarithmic(int start, int end) {
        return diapason(start, end, i -> Math.log(i));
    }
}
