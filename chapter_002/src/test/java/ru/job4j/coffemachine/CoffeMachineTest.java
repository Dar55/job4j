package ru.job4j.coffemachine;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeMachineTest {
    @Test
    public void chargeTest() {
        CoffeMachine d = new CoffeMachine();
        List moneyCount1 = d.changes(50, 12);
        String result = moneyCount1.toString();
        String expect = "[10, 10, 10, 5, 2, 1]";
        assertThat(result, is(expect));

    }
}
