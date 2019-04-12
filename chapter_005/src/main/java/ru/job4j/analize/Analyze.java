package ru.job4j.analize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyze {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, User> map = new HashMap<>();
        int count = 0;
        if (current.containsAll(previous)) {
            throw new NoChangesExeption("Изменений не было.");
        } else {
            for (User user : previous) {
                map.put(user.id, user);
            }
            for (User user : current) {
                User tmp = map.get(user.id);
                if (tmp != null) {
                    if (!tmp.name.equals(user.name)) {
                        info.changed++;
                    }
                    count++;
                }
            }
            info.deleted = previous.size() - count;
            info.added = current.size() - count;
        }
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public String toString() {
            return
                    "added=" + added +
                    ", changed=" + changed +
                    ", deleted=" + deleted;
        }
    }
}
