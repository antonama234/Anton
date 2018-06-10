package ru.job4j.array;

public class BubbleSort {
    public int[] sort(int[] array) {
        for (int i = 0; i != array.length; i++) {

            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        return array;
    }
}


