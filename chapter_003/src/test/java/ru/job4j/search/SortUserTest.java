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
        List<User> input = new ArrayList<User>();
        input.add(new User(1, "Kate","Moscow", 23));
        input.add(new User(2, "Anton","Tula", 21));
        input.add(new User(3, "Lena","Spb", 9));
        Set<User> person = sort.sort(input);
        assertThat(person.iterator().next().getAge(), is(9));
    }

    @Test
    public void whenSortByName() {
        SortUser sort = new SortUser();
        List<User> input = new ArrayList<User>();
        input.add(new User(1, "Ekaterina","Moscow", 23));
        input.add(new User(2, "Anton","Tula", 21));
        input.add(new User(3, "Evgeniya","Spb", 9));
        input.add(new User(4, "Sergey","Rostov", 18));
        input.add(new User(5, "Roma","Tver", 25));
        List<User> person = sort.sortNameLength(input);
        assertThat(person.get(3).getCity(), is("Spb"));
    }

    @Test
    public void whenSortByNameThenByAge() {
        SortUser sort = new SortUser();
        List<User> input = new ArrayList<User>();
        input.add(new User(1, "Kate","Moscow", 23));
        input.add(new User(2, "Anton","Tula", 21));
        input.add(new User(5, "Roma","Tver", 25));
        input.add(new User(3, "Kate","Spb", 9));
        input.add(new User(4, "Roma","Rostov", 18));
        List<User> person = sort.sortByAllFields(input);
        System.out.println(person);
        assertThat(person.get(3).getCity(), is("Rostov"));
    }
}
