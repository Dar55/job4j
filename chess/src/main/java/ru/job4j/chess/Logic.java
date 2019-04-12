package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Math.abs;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {


    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            List<Cell> list = this.figures[index].way(source, dest);
            rst = checkBusy(list);
            if (rst) {
                this.figures[index].position().em = false;
                this.figures[index] = this.figures[index].copy(dest);
                this.figures[index].position().em = true;
            }
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;

        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
    public boolean checkBusy(List<Cell> steps) {
        boolean result = false;
        for (Cell steps1 : steps) {
                    if (steps1.em) {
                        result = false;
                        break;
                    } else
                    {
                        result = true;
                    }
                }
        return result;
    }
}
