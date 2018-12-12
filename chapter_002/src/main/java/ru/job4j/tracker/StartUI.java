package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private boolean working = true;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init(Consumer<String> stringConsumer) {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        List<Integer> range = menu.keys();
        do {
            stringConsumer.accept("Меню.");
            menu.show(s -> System.out.println(s));
            menu.select(this.input.ask("Выберите пунк меню: ", range));
        } while (this.working);
    }

        public void stop() {
            this.working = false;
        }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init(s -> System.out.println(s));
    }
}
