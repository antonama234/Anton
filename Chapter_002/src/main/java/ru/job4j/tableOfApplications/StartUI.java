package ru.job4j.tableOfApplications;

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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню:");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if(GETALL.equals(answer)) {
                this.allItems();
            } else if(UPDATE.equals(answer)) {
                this.updateItem();
            } else if(DELETE.equals(answer)) {
                this.deleteItem();
            } else if(FINDBYID.equals(answer)) {
                this.findId();
            } else if(FINDBYNAME.equals(answer)) {
                this.findName();
            }else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки:");
        String description = this.input.ask("Введите описание заявки:");
        String id = new String();
        Item item = new Item(id, name, description);
        this.tracker.add(item);
        System.out.println("ID новой заявки: " + item.getId());
    }

    private void allItems() {
        System.out.println("---------------------- Заявки ----------------------");
        System.out.println(this.tracker.getAll());
        System.out.println(" ");
    }

    private void updateItem() {

    }

    private void deleteItem() {
        System.out.println("---------------- Поиск заявки по ID ----------------");
        String id = this.input.ask("Введите ID заявки:");
        this.tracker.delete(id);
        System.out.println("Заявка с номером " + id + " удалена.");
        System.out.println(" ");
    }

    private void findId() {

    }

    private void findName() {

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
