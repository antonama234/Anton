package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int newArray = array.length;
        for (int i = 0; i < newArray; i++) {
            for (int j = i + 1; j < newArray; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[newArray - 1];
                    newArray--;
                    j--;
                }
            }

        }
        return Arrays.copyOf(array, newArray);
    }
}
