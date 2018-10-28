package ru.job4j.search;

import java.util.Comparator;

public class User implements Comparable<User> {
    private int id;
    private String name;
    private String city;
    private int age;

    public User(int id, String name, String city, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.getAge());
    }
}
