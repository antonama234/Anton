package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    Tracker tracker = new Tracker();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenGetAllThenShowAllItems() {
        Item first = tracker.add(new Item("testId", "testName", "testDescription"));
        Item second = tracker.add(new Item("testId2", "testName", "testDescription2"));
        Input input = new StubInput(new String[]{"2"});
        new StartUI (input, tracker).init();
        assertThat(
            new String(this.out.toByteArray()),
                is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("---------------------- Заявки ----------------------")
                        .add("ID заявки: testId")
                        .add("Наименование заявки: testName")
                        .add("Описание заявки: testDescription")
                        .add("ID заявки: testId2")
                        .add("Наименование заявки: testName")
                        .add("Описание заявки: testDescription2")
                        .add(" ")
                        .toString()
                )

        );
    }

}
