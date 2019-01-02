package ru.job4j;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentTest {
    @Test
    public void whenTreeScopeMoreBount() {
        Student student = new Student();
        Person Vera = new Person("Vera", 86);
        Person Kate = new Person("Kate", 75);
        Person Nikita = new Person("Nikita", 96);
        Person Roman = new Person("Roman", 80);
        Person Bob = new Person("Bob", 93);
        List<Person> input = Arrays.asList(Vera, Kate, null, Nikita, null, Roman, Bob);
        List<Person> rst = student.levelOf(input, 85);
        assertThat(rst, is(List.of(Nikita, Bob, Vera)));
    }
}
