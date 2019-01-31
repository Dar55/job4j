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
   final String  MENU =  "0. Add new Item."
           + System.lineSeparator()
           + "1. Show all Item"
           + System.lineSeparator()
           + "2. Update Item."
           + System.lineSeparator()
           + "3. Delete Item."
           + System.lineSeparator()
           + "4. Find Item by ID"
           + System.lineSeparator()
           + "5. Find Item by name"
           + System.lineSeparator()
           + "6. Exit"
           + System.lineSeparator();
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
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        Item[] item = tracker.findByName("test name");

        assertThat(this.out.toString(), is(new StringBuilder()
                .append(MENU)
                .append("------------ Adding new item --------------")
                .append (System.lineSeparator())
                .append("------------ New Item with Id : ")
                .append(item[0].getId())
                .append (System.lineSeparator())
                .append("------------ New Item with Name : test name")
                .append (System.lineSeparator())
                .append("------------ New Item with Description : desc")
                .append (System.lineSeparator())
                .toString()
        ));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        new StartUI(input, tracker).init();

        assertThat(this.out.toString(), is(new StringBuilder()
                .append(MENU)
                .append("------------ Замена заявки --------------")
                .append (System.lineSeparator())
                .append("------------Заявка отредактирована-----------")
                .append (System.lineSeparator())
                .toString()
        ));
    }
    @Test
    public void whenDeleteThenTrackerHasRemovedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(item.getId()));
    }
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"5", item.getName(), "y"});
        Item[] items = tracker.findByName("test name");
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                .append(MENU)
                .append("------------ Поиск заявок по имени --------------")
                .append (System.lineSeparator())
                .append("------------  Найденные заявки --------------")
                .append (System.lineSeparator())
                .append ("Id заявки")
                .append (items[0].getId())
                .append("     Имя заявки:test name")
                .append("     Описание заявки:desc")
                .append (System.lineSeparator())
                .toString()
        ));
    }
}
