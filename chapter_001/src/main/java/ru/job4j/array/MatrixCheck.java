package ru.job4j.array;
/**
 * @author Valeriy Vaskov (dar55@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    /**
     * Проверка диагоналей
     * @param data квадратный массив
     * @return результат равности диагоналей
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i][i] != data[i - 1][i - 1]) {
                result = false;
                break;
            }
            if (data[i][(data.length - 1) - i] != data[i - 1][(data.length) - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
