package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void SortByAge () {
        SortUser serl = new SortUser();
        Set<User> im = serl.set(Arrays.asList (
                new User("metr", 23),
                new User("acr", 35),
                new User("detr", 27)));
        String result="";
        for (User us : im) {
            result = result + " " + us.getName() + "  " + us.getAge();
        }
        String expect = " metr" + "  " +  23 + " detr" + "  " + 27 + " acr" + "  " + 35;
        assertThat(result, is(expect));
    }
}
