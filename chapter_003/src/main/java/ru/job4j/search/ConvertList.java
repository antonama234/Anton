package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {

    public List<Integer> convert (List<int[]> list) {
        List<Integer> integers = new ArrayList<Integer>();
        for (int[] i : list) {
            for(int j : i){
                integers.add(j);
            }
        }
        return integers;
    }
}
