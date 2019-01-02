package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenFromListToMap() {
        SortUser sort = new SortUser();
        List<User> input = List.of(
        new User(1, "Kate", "Moscow", 23),
        new User(2, "Anton", "Tula", 21),
        new User(3, "Lena", "Spb", 9));
        Set<User> person = sort.sort(input);
        assertThat(person.iterator().next().getAge(), is(9));
    }

    @Test
    public void whenSortByName() {
        SortUser sort = new SortUser();
        List<User> input = List.of(
        new User(1, "Ekaterina", "Moscow", 23),
        new User(2, "Anton", "Tula", 21),
        new User(3, "Evgeniya", "Spb", 9),
        new User(4, "Sergey", "Rostov", 18),
        new User(5, "Roma", "Tver", 25));
        List<User> person = sort.sortNameLength(input);
        assertThat(person.get(3).getCity(), is("Spb"));
    }

    @Test
    public void whenSortByNameThenByAge() {
        SortUser sort = new SortUser();
        List<User> input = List.of(
        new User(1, "Kate", "Moscow", 23),
        new User(2, "Anton", "Tula", 21),
        new User(5, "Roma", "Tver", 25),
        new User(3, "Kate", "Spb", 9),
        new User(4, "Roma", "Rostov", 18));
        List<User> person = sort.sortByAllFields(input);
        assertThat(person.get(3).getCity(), is("Rostov"));
    }
}
