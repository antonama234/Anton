package ru.job4j.generic;

public class RoleStore extends AbstractStore<Role> {
    private SimpleArray<Role> roles;
    public RoleStore(int size) {
        super(size);
        this.roles = new SimpleArray<>(size);
    }
}
