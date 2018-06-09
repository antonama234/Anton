package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;

        for (boolean i : data) {
            if (i) {
                result = true;
            } else if (!i) {
                result = true;
            }
        }
        return result;
    }
}

