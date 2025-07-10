package com.gol.gameoflife.cell;

import java.util.List;
import java.util.Objects;

public class Cell {
    private final int x;
    private final int y;
    private List<Cell> neighbors;   // cache for future reference

    // Only CellFactory can create objects, as this is a package private constructor
    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || this.getClass()!=obj.getClass()) return false;

        Cell other = (Cell) obj;
        return other.x==this.x && other.y==this.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    public List<Cell> getNeighbors() {
        if(neighbors == null)
            neighbors = List.of(
                CellFactory.get(x-1, y-1), CellFactory.get(x, y-1), CellFactory.get(x+1, y-1),
                CellFactory.get(x-1, y),                      /* this */     CellFactory.get(x+1, y),
                CellFactory.get(x-1, y+1), CellFactory.get(x, y+1), CellFactory.get(x+1, y+1)
            );
        return neighbors;
    }
}
