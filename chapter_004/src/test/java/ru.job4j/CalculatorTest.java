package ru.job4j;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAdd1Until3() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                0, 3, 1,
                MathUtil::add, //static call
                buffer::add // non-static call
        );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Calculator calc = new Calculator();
        List<Double> result = calc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
       assertThat(result, is(expected));
   }
    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Calculator calc = new Calculator();
        List<Double> result = calc.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenLogarifmicFunctionThenLogarifmicResults() {
        Calculator calc = new Calculator();
        List<Double> result = calc.diapason(5, 8, x -> Math.log(x));
        List<Double> expected = Arrays.asList(1.6094379124341003, 1.791759469228055, 1.9459101490553132);
        assertThat(result, is(expected));
    }
}
