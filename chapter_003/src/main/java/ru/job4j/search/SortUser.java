package ru.job4j.search;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort (List<User> list) {
        Set<User> person = new TreeSet<>();
        for (User user : list) {
            person.add(user);
        }
        return person;
    }
}
