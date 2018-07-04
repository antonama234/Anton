package ru.job4j.tableOfApp;

public class Doctor extends Profession {
    private Diagnose diagnose = new Diagnose();
    public Diagnose heal(Pacient pacient) {
        return diagnose;
    }
}

