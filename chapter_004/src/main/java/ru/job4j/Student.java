package ru.job4j;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparator<Person> {

    public List<Person> levelOf(List<Person> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(Comparator.comparingInt(Person::getScope).reversed())
                .takeWhile(sc -> sc.getScope() > bound)
                .collect(Collectors.toList());
    }

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o2.getScope(), o1.getScope());
    }
}
