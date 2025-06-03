package com.gol.gameoflife;

import java.util.List;
import java.util.Objects;

public class Cell {
    private final int x;
    private final int y;

    Cell(int x, int y) { // Only CellFactory can access this
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

    List<Cell> getNeighbors() {
        return List.of(
                CellFactory.get(x-1, y-1), CellFactory.get(x, y-1), CellFactory.get(x+1, y-1),
                CellFactory.get(x-1, y),                      /* this */     CellFactory.get(x+1, y),
                CellFactory.get(x-1, y+1), CellFactory.get(x, y+1), CellFactory.get(x+1, y+1)
        );
    }
}
