package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Валерий Васьков (dar55@yandex.ru)
* @version $Id$
* @since 0.1
*/

public class CalculateTest {
 /**
* Test echo.
*/
@Test
public void whenTakeNameThenTreeEchoPlusName() {
    String input = "Васьков Валерий";
    String expect = "Echo, echo, echo : Васьков Валерий"; 
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
}
}