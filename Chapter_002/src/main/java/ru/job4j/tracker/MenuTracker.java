package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;

    private List<UserAction> actions = new ArrayList<>();
    List<Integer> keys = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public List<Integer> keys() {
        for (UserAction action : actions) {
            keys.add(action.key());
        }
        return keys;
    }

    public class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки: ");
            String descriptoin = input.ask("Введите описание заявки: ");
            String id = new String();
            Item item = new Item(id, name, descriptoin);
            tracker.add(item);
            System.out.println("ID новой заявки : " + item.getId());
            System.out.println("Имя новой заявки : " + item.getName());
            System.out.println("Описание новой заявки : " + item.getDescription());
        }
    }

    public class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------------- Заявки ----------------------");
            for (Item items : tracker.getAll()) {
                System.out.println("ID заявки: " + items.getId());
                System.out.println("Наименование заявки: " + items.getName());
                System.out.println("Описание заявки: " + items.getDescription());
            }
            System.out.println(" ");
        }
    }

    public class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("--------------- Редактирование заявки --------------");
            String id = input.ask("Введите ID заявки:");
            String name = input.ask("Веедите новое имя заявки: ");
            String description = input.ask("Веедите новое описание заявки: ");
            Item item = new Item(id, name, description);
            tracker.update(id, item);
            System.out.println("Заявка " + item.getId() + " отредактирована.");
            System.out.println(" ");
        }
    }

    public class DeleteItem extends BaseAction{

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------------ Удаление заявки -----------------");
            String id = input.ask("Введите ID заявки:");
            if (tracker.delete(id)) {
                System.out.println("Заявка с номером " + id + " удалена.");
            } else {
                System.out.println("Заявка с номером " + id + " не найдена.");
            }
            System.out.println(" ");
        }
    }

    public class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------- Поиск заявки по ID ----------------");
            String id = input.ask("Введите ID заявки: ");
            Item item = tracker.findById(id);
            System.out.println("Найдена заявка с именем: " + item.getName());
            System.out.println("Описание заявки: " + item.getDescription());
            System.out.println(" ");
        }
    }

    public class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по наименованию ------------");
            String key = input.ask("Введите наименование заявки: ");
            Item[] item = tracker.findByName(key);
            System.out.println("Найдена(ы) заявка(и) с ID: " + item.length);
            System.out.println(" ");
        }
    }

    public class ExitProgram extends BaseAction {
        private final StartUI ui;

        public ExitProgram(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }

        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }
    }

    public void fillActions(StartUI ui) {
        actions.add(new AddItem(1, "Создание новой заявки."));
        actions.add(new ShowItems(2, "Отобразить все заявки."));
        actions.add(new MenuTracker.EditItem(3, "Отредактировать заявку."));
        actions.add(new MenuTracker.DeleteItem(4, "Удалить заявку."));
        actions.add(new FindItemById(5, "Найти заявку по ID"));
        actions.add(new FindItemsByName(6, "Найти заявку по имени."));
        actions.add(new ExitProgram(7, "Выход из приложения.", ui));
    }

    public void select(int key) {
        for (UserAction action : actions) {
            if (action.key() == key) {
                action.execute(input, tracker);
            }
        }
    }

    public void show() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
