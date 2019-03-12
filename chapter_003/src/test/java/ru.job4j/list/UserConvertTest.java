package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void testMap() {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        HashMap<Integer, User> map = new HashMap<>();
        List<User> list = new ArrayList<>();
        user1.add(1, "Walter", "Berlin");
        list.add(user1);
        map.put(1, user1);
        user2.add(2, "Carl", "Washington");
        list.add(user2);
        map.put(2, user2);
        user3.add(3, "Peter", "Budapest");
        list.add(user3);
        map.put(3, user3);
        UserConvert convert = new UserConvert();

        assertThat(convert.process(list), is(map));
    }
}
