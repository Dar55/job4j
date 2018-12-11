package ru.job4j.loop;
/**
 * @author Valeriy Vaskov (dar55@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * Находит сумму всех четных чисел.
     * @param start  Первое значение суммы.
     * @param finish Второе значение суммы.
     * @return Сумму всех четных чисел
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int num = start; num <= finish; num++) {
            if ((num % 2) == 0) {
                sum = sum + num;
            }
        }
        return sum;
    }
}
