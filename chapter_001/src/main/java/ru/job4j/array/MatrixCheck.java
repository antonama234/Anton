package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i != data.length; i++) {
            for (int j = 0; j != data.length; j++) {
                if (data[0][0] != data[data.length - 1 - j][data.length - 1 - j] || data[0][data.length - 1] != data[i][data.length - 1 - i]) {
                    result = false;
                }
            }
        }
        return result;
    }
}
