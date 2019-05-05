package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.synchronization.User;
import ru.job4j.synchronization.UserStorage;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserStorageTest {
    private UserStorage storage;
    private User first = new User(0, 500);
    private User second = new User(1, 0);
    private User third = new User(2, 100);

    @Before
    public void before() {
        storage = new UserStorage();
        storage.add(first);
        storage.add(second);
    }

    @Test
    public void whenAddThirdUserAndDeleteFirst() {
        storage.add(third);
        storage.delete(first);
        assertThat(storage.findById(2).getAmount(), is(100));
    }

    @Test
    public void whenUpdateUser() {
        storage.update(new User(1, 400));
        assertThat(storage.findById(1).getAmount(), is(400));
    }

    @Test
    public void whenTransferTwuHundredFronFirstThenHaveMoreMoneyAtSecond() {
        storage.transfer(first.getId(), second.getId(), 200);
        assertThat(storage.findById(1).getAmount(), is(200));
    }
}

