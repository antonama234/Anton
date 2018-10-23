package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConverTest {
    @Test
    public void whenFromListToMap() {
        UserConvert convert = new UserConvert();
        List<User> input = new ArrayList<User>();
        input.add(new User(1, "Kate","Moscow"));
        input.add(new User(2, "Anton","Tula"));
        input.add(new User(3, "Lena","Spb"));
        HashMap<Integer, User> person = convert.process(input);
        assertThat(person.size(), is(3));
    }

    @Test
    public void whenFindByID() {
        UserConvert convert = new UserConvert();
        List<User> input = new ArrayList<User>();
        input.add(new User(1, "Kate","Moscow"));
        input.add(new User(2, "Anton","Tula"));
        input.add(new User(3, "Lena","Spb"));
        HashMap<Integer, User> person = convert.process(input);
            assertThat(person.get(1).getName(), is("Kate"));
    }
}
