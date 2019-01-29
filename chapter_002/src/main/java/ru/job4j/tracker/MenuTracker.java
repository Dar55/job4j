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
            this.actions.add(new AddItem());
            this.actions.add(new ShowItems());
            this.actions.add(new UpdateItem());
            this.actions.add(new DeleteItem());
            this.actions.add(new FindItemById());
            this.actions.add(new FindItemsByName());
            this.actions.add(new ExitProgram());
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


    public class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
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

        @Override
        public String info() {
            return String.format("%s. Add new Item.", key());
        }
    }
    private class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println("ID заявки:" + item.getId() + "      " + "Имя заявки: " + item.name + "      Описание заявки: "  + item.description);
            }
        }

        @Override
        public String info() {
            return String.format("%s. Show all Item", key());
        }
    }

    private class UpdateItem implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info(){return String.format("%s. Update Item.", key());
        }
    }
    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. Delete Item.", key());
        }
    }
    private class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по ID --------------");
            String id = input.ask("Введите ID заявки :");
            Item item = tracker.findById(id);
            System.out.println("------------ Найденная заявка --------------");
            System.out.println("Id заявки" + item.getId() + "     Имя заявки:" + item.getName() + "     Описание заявки:" + item.getDescription());
        }

        @Override
        public String info() {
            return String.format("%s. Find Item by ID", key());
        }
    }
    private class FindItemsByName implements UserAction {
        @Override
        public int key() {
            return 5;
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

        @Override
        public String info() {
            return String.format("%s. Find Item by name", key());
        }
    }
    private class ExitProgram implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return String.format("%s. Exit", key());
        }
    }
}
