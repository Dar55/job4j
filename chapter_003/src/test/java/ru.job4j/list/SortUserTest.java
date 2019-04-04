package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void sortByAge() {
        SortUser serl = new SortUser();
        Set<User> im = serl.set(Arrays.asList(
                new User("metr", 23),
                new User("acr", 35),
                new User("detr", 27)));
        String result = "";
        for (User us : im) {
            result = result + " " + us.getName() + "  " + us.getAge();
        }
        String expect = " metr" + "  " +  23 + " detr" + "  " + 27 + " acr" + "  " + 35;
        assertThat(result, is(expect));
    }
    @Test
    public void sortByLenght() {
        SortUser serl = new SortUser();
        List<User> im = serl.sortNameLength(Arrays.asList(
                new User("Lena", 23),
                new User("Alena", 35),
                new User("Afanasiy", 27)));
        String result = "";
        for (User us : im) {
            result = result + " " + us.getName() + "  " + us.getAge();
        }
        String expect = " Lena" + "  " +  23 + " Alena" + "  " + 35 + " Afanasiy" + "  " + 27;
        assertThat(result, is(expect));
    }
    @Test
    public void sortByAllFields() {
        SortUser serl = new SortUser();
        List<User> im = serl.sortByAllFields(Arrays.asList(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)));
        String result = "";
        for (User us : im) {
            result = result + " " + us.getName() + "  " + us.getAge();
        }
        String expect = " Иван" + "  " +  25 + " Иван" + "  " + 30 + " Сергей" + "  " + 20 + " Сергей" + "  " + 25;
        assertThat(result, is(expect));
    }
}
