package ru.job4j.search;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (list.size() + rows)/rows;
        int index = 0;
        int[][] array = new int[rows][cells];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (index != list.size()) {
                    array[i][j] = list.get(index++);
                }
            }
        }
        return array;
    }
}
