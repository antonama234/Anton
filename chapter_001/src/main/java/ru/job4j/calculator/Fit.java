package ru.job4j.calculator;
/**
 * Программа расчета идеального веса.
 */
public class Fit {

    private double idealWeight;

    /**
     * Идеальный вес для мужщины.
     *
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return idealWeight = (height - 100) * 1.15;
    }

    /**
     * Идеальный вес для женщины.
     *
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return idealWeight = (height - 110) * 1.15;
    }
}