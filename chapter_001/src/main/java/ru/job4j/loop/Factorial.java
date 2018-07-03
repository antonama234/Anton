package ru.job4j.loop;

public class Factorial {

    public int calc(int n) {
        int faktor = 1;
        if (n > 0) {
            for (int index = 1; index <= n; index++) {
                faktor = faktor * index;
            }
        }
        return faktor;
    }
}



