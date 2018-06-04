package ru.job4j.loop;

public class Factorial {
    int faktor = 1;
    public int calc(int n) {
        if (n > 0) {
            for (n = 1; n < 6; n++) {
                faktor = faktor * n;
            }

        } else if (n == 0) {
            return 1;
        }
        return faktor;
    }
}



