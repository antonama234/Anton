package ru.job4j.generic;

public class UserStore extends AbstractStore<User> {
    private SimpleArray<User> users;
    public UserStore(int size) {
        super(size);
        this.users = new SimpleArray<>(size);
    }
}
