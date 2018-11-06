package ru.job4j.search.BankTransfer;

public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public String getRequisites() {
        return requisites;
    }

    public double getValue() {
        return value;
    }
}
