package ru.job4j;

public class Person {
    private String name;
    private int scope;

    public Person(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }
}
