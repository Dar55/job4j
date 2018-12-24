package ru.job4j.tracker;
import  ru.job4j.tracker.models.*;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
    @Test
    public void whenFindItembyId() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        Item item1 = new Item("test2","testDescription",1234L);
        Item item2 = new Item("test3","testDescription",12345L);
        item1.setId("dddd");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        String s = tracker[1]
        assertThat(tracker.findById(S), is(item2));
    }
}
