package ru.job4j;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentTest {
    @Test
    public void whenTreeScopeMoreBount() {
        Student student = new Student();
        List input = List.of(
                new Student("Vera", 86),
                new Student("Kate", 75),
                new Student("Roman", 80),
                new Student("Bob", 93),
                new Student(null, 0));
        List rst = student.levelOf(input, 85);
        assertThat(rst, is(List.of(
                new Student("Bob", 93),
                new Student("Vera", 86))));
    }
}
