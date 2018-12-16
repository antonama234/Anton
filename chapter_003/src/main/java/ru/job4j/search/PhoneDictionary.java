package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        return persons.stream()
                .filter(s -> (s.getName().contains(key))
                || (s.getPhone().contains(key))
                || (s.getSurname().contains(key))
                || (s.getAddress().contains(key))
                ).collect(Collectors.toList());
    }
}