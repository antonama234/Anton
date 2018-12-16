package ru.job4j.search;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserConvert {
    public Map<Integer, User> process(List<User> list) {
        return list.stream().collect(Collectors.toMap(u -> u.getId(), u -> u));
    }
}
