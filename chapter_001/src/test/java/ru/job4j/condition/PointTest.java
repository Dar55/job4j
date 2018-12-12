package ru.job4j.condition;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void checkPoint() {
        Point point1 = new Point(0, 1);
        Point point2 = new Point(2, 5);
        double result = point1.distanceTo(point2);
        double expected = 4.47213595499958;
        assertThat(result, is(expected));
    }
}
