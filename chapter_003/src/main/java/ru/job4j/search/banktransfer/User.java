package ru.job4j.search.banktransfer;

public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User account = (User) o;
        return this.name.equals(account.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
