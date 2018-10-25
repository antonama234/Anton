package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
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
}
