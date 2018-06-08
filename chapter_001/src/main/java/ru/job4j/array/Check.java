package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;

        for (int i = 0; i != data.length; i++) {
                if (data[i] == true) {
                    result = true;
                } else if (data[i] == false) {
                    result = true;
                }
            }
            return result;
         }
    }

