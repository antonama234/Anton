package ru.job4j;

import org.junit.Test;
import ru.job4j.map.User;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {

    @Test
    public void whenOverrideOnlyHashCodeThenHaveTwoDifferentObjects() {
    Map<User, Object> map = new HashMap<>();
    User first = new User("Max", 2, new GregorianCalendar(2001, 01, 01));
    User second = new User("Max", 2, new GregorianCalendar(2001, 01, 01));
    map.put(first, new Object());
    map.put(second, new Object());
    System.out.println(map);
    }
}
