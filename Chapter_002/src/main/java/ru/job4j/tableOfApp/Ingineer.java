package ru.job4j.tableOfApp;

public class Ingineer extends Profession {
    private Build build = new Build();
    public Build construct(House house) {
        return build;
    }
}
