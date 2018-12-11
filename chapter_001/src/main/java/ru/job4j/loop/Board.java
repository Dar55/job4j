package ru.job4j.loop;
/**
 * @author Valeriy Vaskov (dar55@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /**
     * Шахматная доска в псевдографике.
     * @param width Ширина доски
     * @param height Высота доски
     * @return Заполнение доски(текстовая строка)
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 1; i <= height; i++ ) {
            for (int i1 = 1; i1 <= width; i1++) {
                if ((i + i1) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
//    public static void main(String[] args) {
//        Board bo = new Board();
//
//        System.out.println(bo.paint(5,4));
//    }
}