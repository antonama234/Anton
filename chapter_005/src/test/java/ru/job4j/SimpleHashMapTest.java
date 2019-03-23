package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.map.SimpleHashMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleHashMapTest {
    SimpleHashMap<Integer, String> table = new SimpleHashMap<>(10);

    @Before
    public void before() {
        table.insert(5, "FirstElement");
        table.insert(23, "SecondElement");
    }

    @Test
    public void whenAddTwoElementsAndGetFirst() {
        assertThat(table.get(5), is("FirstElement"));
    }

    @Test
    public void whenDeleteOneElementHaveOnlyOne() {
        table.delete(5);
        assertThat(table.getElements(), is(1));
    }
}
