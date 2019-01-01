package ru.job4j;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted(Comparator.comparing(s -> s.name))
                .flatMap(Stream::ofNullable)
                .takeWhile(sc -> sc.scope > bound)
                .collect(Collectors.toList());
    }

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }
}
