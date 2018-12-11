package ru.job4j.loop;
/**
 * @author Valeriy Vaskov (dar55@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Построение  правой части пирамиды.
     * @param height Высота пирамиды
     * @return  построенная правая часть пирамида в текстовой строке
     */
    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
      //  int weight = height; Избыточная переменная
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != height; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    /**
     * Построение  левой части пирамиды.
     * @param height Высота пирамиды
     * @return  построенная леваячасть пирамида в текстовой строке
     */
    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        //int weight = height; Избыточная переменная
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != height; column++) {
                if (row >= height - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    /**
     * Построение  целой пирамиды.
     * @param height Высота пирамиды
     * @return  построенная целой пирамиды в текстовой строке
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}