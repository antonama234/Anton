package ru.job4j;

import org.junit.Test;
import ru.job4j.list.DinamicArray;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DinamicArrayTest {
    DinamicArray<Integer> dinamicArray = new DinamicArray<>(3);

    @Test
    public void whenAddElementThenHaveANewOneAndGetIt() {
        dinamicArray.add(1);
        dinamicArray.add(2);
        assertThat(dinamicArray.get(0), is(1));
    }
}
