package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.ArrayList;
import java.util.List;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhite implements Figure {
    private final Cell position;

    public PawnWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public List way(Cell source, Cell dest) {
        List<Cell> list = new ArrayList<>();
        return list;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
