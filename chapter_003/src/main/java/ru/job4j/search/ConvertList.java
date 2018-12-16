package ru.job4j.search;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertList {
    public List<Integer> convert(List<int[]> list) {
        List<Integer> integers = list.stream()
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
        return integers;
    }
}
