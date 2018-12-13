package ru.job4j.array;
/**
 * @author Valeriy Vaskov (dar55@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
    public class Check {
    /**
     * ПРоверка заполнения массива одинаковыми значениями
     * @param  data массив который Нужно проверить
     * @return  результат проверки
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean b = data[0];
        for (boolean count:data) {
            if(b != count) {
                result = false;
                break;
            }
        }
        return result;
    }
}
