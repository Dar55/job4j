package ru.job4j.max;
/**
 * @author Valeriy Vaskov (dar55@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Определение максимального числа
     * @param first Первое значение для сравнения
     * @param second второе значение для сравнения
     * @return максимальное значение из двух
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    /**
     * Определение максимального числа
     * @param first Первое значение для сравнения
     * @param second второе значение для сравнения
     * @param third третье значение для сравнения
     * @return максимальное значение из трех
     */
    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        return  this.max(temp, third);
    }
}