package ru.job4j.chess.firuges;

import java.util.List;

public interface Figure {
    Cell position();

    List way(Cell source, Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    Figure copy(Cell dest);

}
