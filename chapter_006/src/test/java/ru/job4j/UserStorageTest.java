package ru.job4j;

import org.junit.Test;
import ru.job4j.synchronization.User;
import ru.job4j.synchronization.UserStorage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserStorageTest {
    private class ThreadUser extends Thread {
        private final UserStorage storage;
        private final User first = new User(1, 500);
        private final User second = new User(2, 0);

        private ThreadUser(UserStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            this.storage.transfer(1, 2, 200);
        }
    }

    @Test
    public void when() throws InterruptedException {
        final UserStorage storage = new UserStorage();
        Thread first = new UserStorageTest.ThreadUser(storage);
        Thread second = new UserStorageTest.ThreadUser(storage);
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(storage, is(2));
    }
}
