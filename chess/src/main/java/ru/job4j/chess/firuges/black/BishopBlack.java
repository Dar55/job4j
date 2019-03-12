package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

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
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int posY = dest.y - source.y;
        int posX = dest.x - source.x;
        boolean result = false;
        if (abs(posX) == abs(posY)) {
            int i = 0;
            int x = source.x;
            int y = source.y;
            do {
                    x = x + (dest.x - source.x) / abs(dest.x - source.x);
                    y = y + (dest.y - source.y) / abs(dest.y - source.y);
                    for (Cell steps1 : Cell.values()) {
                            if (steps1.x == x && steps1.y == y) {
                                if (steps1.em) {
                                    result = true;
                                }
                                break;
                            }
                        }
                         if (!result) {
                            steps = new Cell[]{dest};
                            steps[0].em = true;
                            source.em = false;
                } else {
                             throw new OccupiedWayException("Way is not correct");
                         }
                i++;
            } while (i < abs(posX));
        } else {
            throw new ImpossibleMoveException("Figure can't move that");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
