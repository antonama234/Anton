package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private static final String ADD = "1";
    private static final String GETALL = "2";
    private static final String UPDATE = "3";
    private static final String DELETE = "4";
    private static final String FINDBYID = "5";
    private static final String FINDBYNAME = "6";
    private static final String EXIT = "7";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(this.input.ask("Выберите пунк меню: ", range));
        } while (!"y".equals(this.input.ask("Выход?(y): ")));
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        String description = this.input.ask("Введите описание заявки: ");
        String id = new String();
        Item item = new Item(id, name, description);
        this.tracker.add(item);
        System.out.println("ID новой заявки: " + item.getId());
    }

    private void allItems() {
        System.out.println("---------------------- Заявки ----------------------");
        for (Item items : tracker.getAll()) {
            System.out.println("ID заявки: " + items.getId());
            System.out.println("Наименование заявки: " + items.getName());
            System.out.println("Описание заявки: " + items.getDescription());
        }
        System.out.println(" ");
    }

    private void updateItem() {
        System.out.println("--------------- Редактирование заявки --------------");
        String id = this.input.ask("Введите ID заявки:");
        String name = this.input.ask("Веедите новое имя заявки: ");
        String description = this.input.ask("Веедите новое описание заявки: ");
        Item item = new Item(id, name, description);
        this.tracker.update(id, item);
        System.out.println("Заявка " + item.getId() + " отредактирована.");

        System.out.println(" ");
    }

    private void deleteItem() {
        System.out.println("------------------ Удаление заявки -----------------");
        String id = this.input.ask("Введите ID заявки:");
        if (this.tracker.delete(id)) {
            System.out.println("Заявка с номером " + id + " удалена.");
        } else {
            System.out.println("Заявка с номером " + id + " не найдена.");
        }
        System.out.println(" ");
    }

    private void findId() {
        System.out.println("---------------- Поиск заявки по ID ----------------");
        String id = this.input.ask("Введите ID заявки: ");
        Item item = this.tracker.findById(id);
        System.out.println("Найдена заявка с именем: " + item.getName());
        System.out.println("Описание заявки: " + item.getDescription());
        System.out.println(" ");
    }

    private void findName() {
        System.out.println("------------ Поиск заявки по наименованию ------------");
        String key = this.input.ask("Введите наименование заявки: ");
        Item[] item = this.tracker.findByName(key);
        System.out.println("Найдена(ы) заявка(и) с ID: " + item.length);
        System.out.println(" ");
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("1. Создание новой заявки.");
        System.out.println("2. Отобразить все заявки.");
        System.out.println("3. Отредактировать заявку.");
        System.out.println("4. Удалить заявку.");
        System.out.println("5. Найти заявку по ID");
        System.out.println("6. Найти заявку по имени.");
        System.out.println("7. Выход из приложения.");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
