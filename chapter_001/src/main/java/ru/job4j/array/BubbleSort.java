package ru.job4j.array;
/**
 * @author Valeriy Vaskov (dar55@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     * Пузырьковая сортировка массива
     * @param array массив который надо отсортировать
     * @return отсортированный массив
     */
    public int[] sort(int[] array) {
        int temp;
        for (int count1 = array.length;count1 > 0;count1--) {
            for (int count = 0; count < count1 - 1; count++) {
                if (array[count] > array[count + 1]) {
                    temp = array[count + 1];
                    array[count + 1] = array[count];
                    array[count] = temp;
                }
            }
        }
        return array;
    }
}
