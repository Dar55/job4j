package ru.job4j.pseudo;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriagleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                        .append("   +   ")
                        .append(" +   + ")
                        .append("+     +")
                        .append("+++++++")
                        .toString()
                )
        );
    }
}
