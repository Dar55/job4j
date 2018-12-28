package ru.job4j.tracker;
import  ru.job4j.tracker.models.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYNAME = "5";
    private static final String FINDBYID = "4";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    private StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**e
     * Основой цикл программы.
     */
    private void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Select:");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYNAME.equals(answer)) {
                this.findItembyName();
            } else if (FINDBYID.equals(answer)) {
                this.findItembyID();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 123L);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    /**
     * Метод реализует показ всех ненулевых итемов
     */
    private void showItems() {
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            System.out.println("ID заявки:" + item.getId() + "      " + "Имя заявки: " + item.name + "      Описание заявки: "  + item.description);
        }
    }
    private void editItem() {
        System.out.println("------------ Замена заявки --------------");
        String id = this.input.ask("Введите ID заявки, которую хотите заменить :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 123L);
        if (tracker.replace(id, item)) {
            System.out.println("------------Заявка отредактирована-----------");
        } else {
            System.out.println("------------Заявка не изменена-----------");
        }
    }
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки :");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Заявка удалена успешно --------------");
        } else {
            System.out.println("------------ Заявка не удалена --------------");
        }
    }
    private void findItembyName() {
        System.out.println("------------ Поиск заявок по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] items = this.tracker.findByName(name);
        System.out.println("------------  Найденные заявки --------------");
        for (Item item : items) {
            System.out.println("Id заявки" + item.getId() + "     Имя заявки:" + item.getName() + "     Описание заявки:" + item.getDescription());
        }
    }
    private void findItembyID() {
        System.out.println("------------ Поиск заявок по ID --------------");
        String id = this.input.ask("Введите ID заявки :");
        Item item = this.tracker.findById(id);
        System.out.println("------------ Найденная заявка --------------");
        System.out.println("Id заявки" + item.getId() + "     Имя заявки:" + item.getName() + "     Описание заявки:" + item.getDescription());
    }
    private void showMenu() {
        System.out.println("0. Add new Item" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()
                + "2. Edit item" + System.lineSeparator()
                + "3. Delete item" + System.lineSeparator()
                + "4. Find item by Id" + System.lineSeparator()
                + "5. Find items by name" + System.lineSeparator()
                + "6. Exit Program" + System.lineSeparator());
        // добавить остальные пункты меню.
    }


    /**
     * Запускт программы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}