package ru.job4j.tableOfApp;

public class Doctor extends Profession {
    public class Diagnose {
    }

    public Diagnose diagnose = new Diagnose();
    public Diagnose heal(Pacient pacient) {
        return diagnose;
    }
}

