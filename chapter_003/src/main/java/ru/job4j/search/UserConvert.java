package ru.job4j.search;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> person = new HashMap<Integer, User>();
            for (User user : list) {
                person.put(user.getId(), user);
            }
        return person;
    }
}
