package com.gol.gameoflife;

import java.util.HashSet;
import java.util.Set;

public class Grid {
    private final Set<Cell> liveCells;

    Grid(Set<Cell> liveCells) {
        this.liveCells = liveCells;
    }

    public Set<Cell> getLiveCells() {
        return liveCells;
    }

    public Set<Cell> getPotentialCells() {
        Set<Cell> neighbourCells = new HashSet<>(liveCells);
        for(Cell liveCell: liveCells) {
            neighbourCells.addAll(liveCell.getNeighbors());
        }
        return neighbourCells;
    }

    public int getLiveNeighboursCount(Cell cell) {
        Set<Cell> neighbourCells = new HashSet<>(cell.getNeighbors());
        int count=0;

        for(Cell neighbourCell: neighbourCells) {
            if(liveCells.contains(neighbourCell)) count++;
        }
        return count;
    }
}
