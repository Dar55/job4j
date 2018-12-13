package ru.job4j.array;
/**
 * @author Valeriy Vaskov (dar55@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    /**
     * Переворачивания массива
     * @param  array массив который нужно перевернуть
     * @return  массив в обратной последовательности
     */
    public int[] back(int[] array) {
        int temp;
        for (int count = array.length / 2; count > 0; count--) {
            temp = array[array.length - count];
            array[array.length - count] = array[count - 1];
            array[count - 1] = temp;
        }
        return array;
    }
}
