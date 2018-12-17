package ru.job4j.search;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConverTest {
    @Test
    public void whenFromListToMap() {
        UserConvert convert = new UserConvert();
        List<User> input = Arrays.asList(
                new User(1, "Kate", "Moscow", 21),
                new User(2, "Anton", "Tula", 5),
                new User(3, "Lena", "Spb", 16));
        Map<Integer, User> person = convert.process(input);
        assertThat(person.size(), is(3));
    }

    @Test
    public void whenFindByID() {
        UserConvert convert = new UserConvert();
        List<User> input = Arrays.asList(
                new User(1, "Kate", "Moscow", 21),
                new User(2, "Anton", "Tula", 5),
                new User(3, "Lena", "Spb", 16));
        Map<Integer, User> person = convert.process(input);
        assertThat(person.get(1).getName(), is("Kate"));
    }
}
