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
    StringJoiner menu = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
            .add("Меню.")
            .add("1. Создание новой заявки.")
            .add("2. Отобразить все заявки.")
            .add("3. Отредактировать заявку.")
            .add("4. Удалить заявку.")
            .add("5. Найти заявку по ID")
            .add("6. Найти заявку по имени.")
            .add("7. Выход из приложения.");

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenAddItemThenHasNewItem() {
        Item item = new Item("testId", "testName", "testDescription");
        Input input = new StubInput(new String[]{"1", item.getName(), item.getDescription(), "7"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Добавление новой заявки --------------" + System.lineSeparator())
                                .append("ID новой заявки: " + tracker.getAll()[0].getId())
                                .append("" + System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenGetAllThenShowAllItems() {
        Item first = tracker.add(new Item("testId", "testName", "testDescription"));
        Item second = tracker.add(new Item("testId2", "testName2", "testDescription2"));
        Input input = new StubInput(new String[]{"2", "7"});
        new StartUI(input, tracker).init();
        assertThat(
            new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                        .append(menu)
                        .append("---------------------- Заявки ----------------------" + System.lineSeparator())
                        .append("ID заявки: " + tracker.getAll()[0].getId() + System.lineSeparator())
                        .append("Наименование заявки: testName" + System.lineSeparator())
                        .append("Описание заявки: testDescription" + System.lineSeparator())
                        .append("ID заявки: " + tracker.getAll()[1].getId() + System.lineSeparator())
                        .append("Наименование заявки: testName2" + System.lineSeparator())
                        .append("Описание заявки: testDescription2" + System.lineSeparator())
                        .append(" " + System.lineSeparator())
                        .append(menu)
                        .toString()
                )
        );
    }

    @Test
    public void whenUpdateItemThenHasNewNameAndDesc() {
        Item first = tracker.add(new Item("testId", "testName", "testDescription"));
        Item second = tracker.add(new Item("testId2", "testName2", "testDescription2"));
        Input input = new StubInput(new String[]{"3", first.getId(), second.getName(), second.getDescription(), "7"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                    is(
                        new StringBuilder()
                                .append(menu)
                                .append("--------------- Редактирование заявки --------------" + System.lineSeparator())
                                .append("Заявка " + first.getId() + " отредактирована." + System.lineSeparator())
                                .append(" " + System.lineSeparator())
                                .append(menu)
                                .toString()
                    )
        );
    }
}
