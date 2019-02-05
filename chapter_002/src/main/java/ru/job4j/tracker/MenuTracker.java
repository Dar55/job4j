package ru.job4j.tracker;
import  ru.job4j.tracker.models.*;

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

    public void fillActions() {
            this.actions.add(new AddItem(0, "Add new Item."));
            this.actions.add(new ShowItems(1, "Show all Item"));
            this.actions.add(new UpdateItem(2, "Update Item."));
            this.actions.add(new DeleteItem(3, "Delete Item."));
            this.actions.add(new FindItemById(4, "Find Item by ID"));
            this.actions.add(new FindItemsByName(5, "Find Item by name"));
            this.actions.add(new ExitProgram(6, "Exit"));
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
    public abstract class BaseAction implements UserAction {
        private final int key;
        private final String name;

        protected BaseAction(final int key, final String name) {
            this.key = key;
            this.name = name;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key, this.name);
        }
    }


    public class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc, 123L);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDescription());
        }

    }
    private class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println("ID заявки:" + item.getId() + "      " + "Имя заявки: " + item.name + "      Описание заявки: "  + item.description);
            }
        }

    }

    private class UpdateItem extends BaseAction {
        public UpdateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Замена заявки --------------");
            String id = input.ask("Введите ID заявки, которую хотите заменить :");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc, 123L);
            boolean b = tracker.replace(id, item);
            if (b) {
                System.out.println("------------Заявка отредактирована-----------");
            } else {
                System.out.println("------------Заявка не изменена-----------");
            }
        }

    }
    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите ID заявки :");
            boolean b = tracker.delete(id);
            if (b) {
                System.out.println("------------ Заявка удалена успешно --------------");
            } else {
                System.out.println("------------ Заявка не удалена --------------");
            }
        }

    }
    private class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по ID --------------");
            String id = input.ask("Введите ID заявки :");
            Item item = tracker.findById(id);
            System.out.println("------------ Найденная заявка --------------");
            System.out.println("Id заявки" + item.getId() + "     Имя заявки:" + item.getName() + "     Описание заявки:" + item.getDescription());
        }

    }
    private class FindItemsByName extends BaseAction {
        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по имени --------------");
            String name = input.ask("Введите имя заявки :");
            Item[] items = tracker.findByName(name);
            System.out.println("------------  Найденные заявки --------------");
            for (Item item : items) {
                System.out.println("Id заявки" + item.getId() + "     Имя заявки:" + item.getName() + "     Описание заявки:" + item.getDescription());
            }
        }

    }
    private class ExitProgram extends BaseAction {
        public ExitProgram(int key, String name) {
            super(key, name);
        }


        @Override
        public void execute(Input input, Tracker tracker) {

        }

    }
}
