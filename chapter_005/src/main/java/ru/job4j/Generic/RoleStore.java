package ru.job4j.Generic;

public class RoleStore extends AbstractStore<Role> {
    private SimpleArray<Role> roles;
    public RoleStore(int size) {
        super(size);
        this.roles = new SimpleArray<>(size);
    }
}
