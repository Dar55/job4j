package ru.job4j.array;
/**
 * @author Valeriy Vaskov (dar55@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     * РАсчет квадратов значений в массиве
     * @param  bound количество значений массива
     * @return  массив из квадратов значений
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i=0; i<bound;i++) {
            rst[i]= (int) Math.pow(i+1,2);
        }
        return rst;
    }
}