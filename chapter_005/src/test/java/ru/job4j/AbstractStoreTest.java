package ru.job4j;

import org.junit.Test;
import ru.job4j.generic.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AbstractStoreTest {
    private UserStore userStore = new UserStore(3);
    User first = new User("1");
    User second = new User("2");
    User third = new User("3");

    @Test
    public void whenAddElementThenHaveANewOne() {
        userStore.add(first);
        userStore.add(second);
        assertThat(userStore.get(1), is(second));
    }

    @Test
    public void whenReplaceElementThenHaveNewModel() {
        userStore.add(first);
        userStore.add(second);
        userStore.replace("2", third);
        assertThat(userStore.findById("2"), is(third));
    }

    @Test
    public void whenDeleteElementThenRemainTwoElements() {
        userStore.add(first);
        userStore.add(second);
        userStore.delete("1");
        assertThat(userStore.get(0), is(second));
    }

    @Test
    public void whenFindByID() {
        userStore.add(first);
        userStore.add(second);
        assertThat(userStore.findById("2"), is(second));
    }
}
