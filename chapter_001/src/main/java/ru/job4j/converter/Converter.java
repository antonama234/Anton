package ru.job4j.converter;
/**
 * Корвертор валюты.
 */
public class Converter {

    private int usd;
    private int eur;

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return eur = value / 70;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return usd = value / 60;
    }
}
