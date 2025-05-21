package com.gol.gameoflife;

import java.util.List;
import java.util.Objects;

public class Cell {
    private final int x;
    private final int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Cell> getNeighbors() {
        return List.of(new Cell(x-1, y-1), new Cell(x, y-1),new Cell(x+1, y-1),
                new Cell(x-1, y), new Cell(x, y),new Cell(x+1, y),
                new Cell(x-1, y+1), new Cell(x, y+1),new Cell(x+1, y+1));
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
}
