package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public List way(Cell source, Cell dest) {
        List<Cell> list = new ArrayList<>();
        int i = 0;
        int x = source.x;
        int y = source.y;
        //int count = 0;
        if (source.y != dest.y && source.x == dest.x) {
            for (i = 0; i < abs(source.y - dest.y); i++) {
                y = y + (dest.y - source.y) / abs(dest.y - source.y);
                for (Cell steps1 : Cell.values()) {
                    if (steps1.x == x && steps1.y == y) {
                        list.add(steps1);
                        break;
                    }
                }
            }
        } else if (source.x != dest.x && source.y == dest.y) {
            for (i = 0; i < abs(source.x - dest.x); i++) {
                x = x + (dest.x - source.x) / abs(dest.x - source.x);
                for (Cell steps1 : Cell.values()) {
                    if (steps1.x == x && steps1.y == y) {
                        list.add(steps1);
                        break;
                    }
                }
            }
        }
        return list;
    }
    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
