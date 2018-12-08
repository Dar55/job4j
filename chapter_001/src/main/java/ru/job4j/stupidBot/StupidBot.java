package ru.job4j.stupidBot;

    /**
     * @author Valeriy Vaskov (dar55@yandex.ru)
     * @version $Id$
     * @since 0.1
     */
    public class StupidBot {
     /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */

        public String answer(String question) {
            String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
            if ("Привет, Бот.".equals(question)) {
                rsl = "Привет, умник.";
            } else if ("Пока.".equals(question)) {
                rsl = "До скорой встречи.";
            }
            return rsl;
        }
    }

