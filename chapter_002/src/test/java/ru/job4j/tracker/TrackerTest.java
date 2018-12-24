package ru.job4j.tracker;
import  ru.job4j.tracker.models.*;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test2","testDescription2",1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    /*
     Тестируем сразу два метода, сначала на поиск по имени, потом поиск по вйди,
     т.к. я так и не придумал, как добраться до автоматически генерируемого ID, после нахождения ID
     по этому ID ищем элемент.
     */
    @Test
    public void whenFindItembyId() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        Item item1 = new Item("test2","testDescription",1234L);
        Item item2 = new Item("test3","testDescription",12345L);
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Item[] find = tracker.findByName("test1");
        String S = find[0].getId();
        assertThat(tracker.findById(S).getName(), is("test1"));
    }
    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        Item item1 = new Item("test2","testDescription",1234L);
        Item item2 = new Item("test3","testDescription",12345L);
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Item[] find = tracker.findByName("test2");
        String S = find[0].getId();
        tracker.delete(S);
       assertNull(tracker.findById(S));
    }
}
