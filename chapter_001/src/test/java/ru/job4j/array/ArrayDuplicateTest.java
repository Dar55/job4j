package ru.job4j.array;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate check = new ArrayDuplicate();
        String[] input = new String[]
                {"Привет", "Мир", "Привет", "Супер", "Мир", "Нямя"};
        String[] result = check.remove(input);
        String[] wait = new String[]
         {"Привет", "Мир", "Супер", "Нямя"};
        assertThat(wait, is(result));
    }
}