package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getREsult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenAddOneMinusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.sub(10D, 5D);
        double result = calc.getREsult();
        double expected = 5D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenAddOneMultipleOneThenTwo() {
        Calculator calc = new Calculator();
        calc.multiple(10D, 5D);
        double result = calc.getREsult();
        double expected = 50D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenAddOneDivineOneThenTwo() {
        Calculator calc = new Calculator();
        calc.div(10D, 5D);
        double result = calc.getREsult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}
