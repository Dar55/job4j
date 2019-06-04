package ru.job4j.chess.firuges.black;

//import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
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
public class KingBlack implements Figure {
    private final Cell position;

    public KingBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public List way(Cell source, Cell dest) {
        List<Cell> list = new ArrayList<>();

  //      System.out.println("by   " +source.y + "ey   " + dest.y + "bx   " + source.x + "ex   " + dest.x);
        int res = abs(source.x - dest.x + source.y - dest.y);
       if (((source.x == dest.x || (source.y == dest.y)) &&( res == 1)) || (source.x != dest.x && (source.y != dest.y) &&(res == 2))) {
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
        return new KingBlack(dest);
    }
}
