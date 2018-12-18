package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AdditionaTaskTest {
    @Test
    public void whenSecondArrayMore(){
        int[] array1 = new int[] {1, 2, 3, 4, 5, 9};
        int[] array2 = new int[] {1, 4, 7, 8, 12, 21, 37, 44};
        AdditionaTask test = new AdditionaTask();
        int[] result = test.unionTwoArray(array1, array2);
        int[] expect = new int[] {1, 1, 2, 3, 4, 4, 5, 7, 8, 9, 12, 21, 37, 44};
        assertThat(result, is(expect));
    }
    @Test
    public void whenFirstArrayMore(){
        int[] array1 = new int[] {1, 2, 3, 4, 5, 9, 12, 17};
        int[] array2 = new int[] {1, 4, 7, 8};
        AdditionaTask test = new AdditionaTask();
        int[] result = test.unionTwoArray(array1, array2);
        int[] expect = new int[] {1, 1, 2, 3, 4, 4, 5, 7, 8, 9, 12, 17};
        assertThat(result, is(expect));
    }
    @Test
    public void whenEqualArrays(){
        int[] array1 = new int[] {1, 2, 3, 4};
        int[] array2 = new int[] {1, 4, 7, 8};
        AdditionaTask test = new AdditionaTask();
        int[] result = test.unionTwoArray(array1, array2);
        int[] expect = new int[] {1, 1, 2, 3, 4, 4, 7, 8};
        assertThat(result, is(expect));
    }
}