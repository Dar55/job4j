package ru.job4j.stupidbot;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

    /**
     * @author Valeriy Vaskov (dar55@yandex.ru)
     * @version $Id$
     * @since 0.1
     */
    public class StupidBotTest {
        @Test
        public void whenGreetBot() {
            StupidBot bot = new StupidBot();
            assertThat(
                    bot.answer("Привет, Бот."),
                    is("Привет, умник.")
            );
        }

        @Test
        public void whenByuBot() {
            StupidBot bot = new StupidBot();
            assertThat(
                    bot.answer("Пока."),
                    is("До скорой встречи.")
            );
        }

        @Test
        public void whenUnknownBot() {
            StupidBot bot = new StupidBot();
            assertThat(
                    bot.answer("Сколько будет 2 + 2?"),
                    is("Это ставит меня в тупик. Спросите другой вопрос.")
            );
        }
}
