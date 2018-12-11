package ru.job4j.max;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

 public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
     @Test
     public void whenFirstMoreSecond() {
         Max maxim = new Max();
         int result = maxim.max(3, 1);
         assertThat(result, is(3));
     }
     @Test
     public void chooseBetweenThremMaxThree() {
         Max maxim = new Max();
         int result = maxim.max(3, 1, 5);
         assertThat(result, is(5));
     }
     @Test
     public void chooseBetweenThreemMaxTwo() {
         Max maxim = new Max();
         int result = maxim.max(3, 7, 5);
         assertThat(result, is(7));
     }
     @Test
     public void chooseBetweenThreemMaxOne() {
         Max maxim = new Max();
         int result = maxim.max(6, 1, 5);
         assertThat(result, is(6));
     }
}
