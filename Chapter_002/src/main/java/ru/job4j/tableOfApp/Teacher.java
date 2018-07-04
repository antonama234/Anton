package ru.job4j.tableOfApp;

public class Teacher extends Profession {
    private Education education = new Education();
    public Education teach(Student student) {
        return education;
    }
}
