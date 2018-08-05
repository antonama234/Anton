package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionsLentgh() {
        return this.actions.size();
    }

    public class AddItem implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            String id = new String();
            Item item = new Item(id, name, desc);
            tracker.add(item);
            System.out.println("------------ ID новой заявки : " + item.getId());
            System.out.println("------------ Имя новой заявки : " + item.getName());
            System.out.println("------------ Описание новой заявки : " + item.getDescription());
        }

        @Override
        public String info() {
            return "Новая заявка добавлена.";
        }
    }

    public class ShowItems implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return "Заявка отредактирована.";
        }
}

    public class EditItem implements UserAction {
        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return "Заявки: ";
        }
    }

    public class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 4;
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

        @Override
        public String info() {
            return "Заявка удалена.";
        }
    }

    public class FindItemById implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------- Поиск заявки по ID ----------------");
            String id = input.ask("Введите ID заявки: ");
            Item item = tracker.findById(id);
            System.out.println("Найдена заявка с именем: " + item.getName());
            System.out.println("Описание заявки: " + item.getDescription());
            System.out.println(" ");
        }

        @Override
        public String info() {
            return "Найдена заявка: ";
        }
    }

    public class FindItemsByName implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по наименованию ------------");
            String key = input.ask("Введите наименование заявки: ");
            Item[] item = tracker.findByName(key);
            System.out.println("Найдена(ы) заявка(и) с ID: " + item.length);
            System.out.println(" ");
        }

        @Override
        public String info() {
            return "Найдены заявки: ";
        }
    }

    public class ExitProgram implements UserAction {
        @Override
        public int key() {
            return 7;
        }

        public void execute(Input input, Tracker tracker) {
            input.ask("Выход?(y): ");
        }

        @Override
        public String info() {
            return "Выход";
        }
    }

    public void fillActions() {
        this.actions.add(new AddItem(1, "Создание новой заявки."));
        this.actions.add(new ShowItems(2, "Отобразить все заявки."));
        this.actions.add(new MenuTracker.EditItem(3, "Отредактировать заявку."));
        this.actions.add(new MenuTracker.DeleteItem(4, "Удалить заявку."));
        this.actions.add(new FindItemById(5, "Найти заявку по ID"));
        this.actions.add(new FindItemsByName(6, "Найти заявку по имени."));
        this.actions.add(new ExitProgram(7, "Выход из приложения."));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
