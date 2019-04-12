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
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public List way(Cell source, Cell dest) {
        List<Cell> list = new ArrayList<>();
        if ((abs(source.y-dest.y) == 2 && abs(source.x - dest.x) == 1) || (abs(source.y-dest.y) == 1 && abs(source.x - dest.x) == 2)) {
                for (Cell steps1 : Cell.values()) {
                    if (steps1.x == dest.x && steps1.y == dest.y) {
                        list.add(steps1);
                        break;
                    }
                }
            }
        return list;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
