package ru.job4j.analize;

import java.util.List;

public class Analyze {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info(0, 0, 0);
        if (current.containsAll(previous)) {
            throw new NoChangesExeption("Изменений не было.");
        } else {
            for (User user : previous) {
                if (!current.contains(user)) {
                    info.deleted++;
                }
            }
            for (User user : previous) {
                if (current.contains(user.id) && !current.contains(user.name)) {
                    info.changed++;
                }
            }
            for (User user : current) {
                if (!previous.contains(user)) {
                    info.added++;
                }
            }
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
            return "Info{" +
                    "added=" + added +
                    ", changed=" + changed +
                    ", deleted=" + deleted +
                    '}';
        }
    }
}
