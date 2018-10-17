package ru.job4j.search;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> person = new HashMap<Integer, User>();
            for (int i = 0; i < list.size(); i++) {
                User user = list.get(i);
                person.put(list.get(i).getId(), user);
            }
        return person;
    }
}
