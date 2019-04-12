package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.analize.Analyze;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalyzeTest {
    private Analyze analyze = new Analyze();
    List<Analyze.User> previous = new ArrayList<>();

    @Before
    public void beforeTest() {
        analyze = new Analyze();
        previous = List.of(new Analyze.User(1, "Dmitry"),
                           new Analyze.User(2, "Oksana"),
                           new Analyze.User(3, "Anna"));
    }

    @Test
    public void test() {
        List<Analyze.User> current = new ArrayList<>(previous);
        current.add(new Analyze.User(4, "Vera"));
        current.add(new Analyze.User(5, "Vladimir"));
        current.set(0, new Analyze.User(1, "Stepan"));
        current.remove(1);
        assertThat(analyze.diff(previous, current).toString(), is("added=2, changed=1, deleted=1"));
    }
}