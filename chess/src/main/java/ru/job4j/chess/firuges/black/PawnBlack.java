package ru.job4j.chess.firuges.black;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
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
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
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
        int y = source.y;
        if ((source.y == dest.y + 1 && source.x == dest.x) || (source.y == 6 && source.y == dest.y + 2 && source.x == dest.x)) {
            for (i = 0; i < abs(source.y - dest.y); i++) {
                y = y - 1;
                for (Cell steps1 : Cell.values()) {
                    if (steps1.x == dest.x && steps1.y == y) {
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
        return new PawnBlack(dest);
    }
}
