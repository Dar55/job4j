package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import  ru.job4j.tracker.models.*;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import java.util.StringJoiner;

public class StartUITest {
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
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        Item[] item = tracker.findByName("test name");
        assertThat(this.out.toString(), is(new StringBuilder()
                .append("0. Add new Item")
                .append (System.lineSeparator())
                .append("1. Show all items")
                .append (System.lineSeparator())
                .append ("2. Edit item")
                .append (System.lineSeparator())
                .append("3. Delete item")
                .append (System.lineSeparator())
                .append ("4. Find item by Id")
                .append (System.lineSeparator())
                .append ("5. Find items by name")
                .append (System.lineSeparator())
                .append ("6. Exit Program")
                .append (System.lineSeparator())
                .append (System.lineSeparator())
                .append("------------ Добавление новой заявки --------------")
                .append (System.lineSeparator())
                .append("------------ Новая заявка с getId : ")
                .append(item[0].getId())
                .append("-----------")
                .append (System.lineSeparator())
                .append("0. Add new Item")
                .append (System.lineSeparator())
                .append("1. Show all items")
                .append (System.lineSeparator())
                .append ("2. Edit item")
                .append (System.lineSeparator())
                .append("3. Delete item")
                .append (System.lineSeparator())
                .append ("4. Find item by Id")
                .append (System.lineSeparator())
                .append ("5. Find items by name")
                .append (System.lineSeparator())
                .append ("6. Exit Program")
                .append (System.lineSeparator())
                .append (System.lineSeparator())
                .toString()
        ));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                .append("0. Add new Item")
                .append (System.lineSeparator())
                .append("1. Show all items")
                .append (System.lineSeparator())
                .append ("2. Edit item")
                .append (System.lineSeparator())
                .append("3. Delete item")
                .append (System.lineSeparator())
                .append ("4. Find item by Id")
                .append (System.lineSeparator())
                .append ("5. Find items by name")
                .append (System.lineSeparator())
                .append ("6. Exit Program")
                .append (System.lineSeparator())
                .append (System.lineSeparator())
                .append("------------ Замена заявки --------------")
                .append (System.lineSeparator())
                .append("------------Заявка отредактирована-----------")
                .append (System.lineSeparator())
                .append("0. Add new Item")
                .append (System.lineSeparator())
                .append("1. Show all items")
                .append (System.lineSeparator())
                .append ("2. Edit item")
                .append (System.lineSeparator())
                .append("3. Delete item")
                .append (System.lineSeparator())
                .append ("4. Find item by Id")
                .append (System.lineSeparator())
                .append ("5. Find items by name")
                .append (System.lineSeparator())
                .append ("6. Exit Program")
                .append (System.lineSeparator())
                .append (System.lineSeparator())
                .toString()
        ));
    }
    @Test
    public void whenDeleteThenTrackerHasRemovedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(item.getId()));
    }
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        Item[] items = tracker.findByName("test name");
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                .append("0. Add new Item")
                .append (System.lineSeparator())
                .append("1. Show all items")
                .append (System.lineSeparator())
                .append ("2. Edit item")
                .append (System.lineSeparator())
                .append("3. Delete item")
                .append (System.lineSeparator())
                .append ("4. Find item by Id")
                .append (System.lineSeparator())
                .append ("5. Find items by name")
                .append (System.lineSeparator())
                .append ("6. Exit Program")
                .append (System.lineSeparator())
                .append (System.lineSeparator())
                .append("------------ Поиск заявок по имени --------------")
                .append (System.lineSeparator())
                .append("------------  Найденные заявки --------------")
                .append (System.lineSeparator())
                .append ("Id заявки")
                .append (items[0].getId())
                .append("     Имя заявки:test name")
                .append("     Описание заявки:desc")
                .append (System.lineSeparator())
                .append("0. Add new Item")
                .append (System.lineSeparator())
                .append("1. Show all items")
                .append (System.lineSeparator())
                .append ("2. Edit item")
                .append (System.lineSeparator())
                .append("3. Delete item")
                .append (System.lineSeparator())
                .append ("4. Find item by Id")
                .append (System.lineSeparator())
                .append ("5. Find items by name")
                .append (System.lineSeparator())
                .append ("6. Exit Program")
                .append (System.lineSeparator())
                .append (System.lineSeparator())
                .toString()
        ));
    }
}
