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
        User user = new User();
        HashMap<Integer, User> map = new HashMap<>();
        List<User> list = new ArrayList<>();
        user.add(1, "Walter", "Berlin");
        list.add(user);
        map.put(1, user);
        user.add(2, "Carl", "Washington");
        list.add(user);
        map.put(2, user);
        user.add(3, "Peter", "Budapest");
        list.add(user);
        map.put(3, user);
        UserConvert convert = new UserConvert();

        assertThat(convert.process(list), is(map));
    }
}
