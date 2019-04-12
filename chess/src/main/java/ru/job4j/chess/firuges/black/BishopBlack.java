package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.OccupiedWayException;
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
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public List<Cell> way(Cell source, Cell dest) {
        List<Cell> list = new ArrayList<>();
        int posY = dest.y - source.y;
        int posX = dest.x - source.x;
        if (abs(posX) == abs(posY)) {
            int i = 0;
            int x = source.x;
            int y = source.y;
            do {
                x = x + (dest.x - source.x) / abs(dest.x - source.x);
                y = y + (dest.y - source.y) / abs(dest.y - source.y);
                for (Cell steps1 : Cell.values()) {
                    if (steps1.x == x && steps1.y == y) {
                        list.add(steps1);
                    }
                }
                i++;
            } while (i < abs(posX));
        }
        return list;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
