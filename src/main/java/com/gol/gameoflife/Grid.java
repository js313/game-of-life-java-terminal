package com.gol.gameoflife;

import com.gol.gameoflife.cell.Cell;

import java.util.HashSet;
import java.util.Set;

public record Grid(Set<Cell> liveCells) {
    private Set<Cell> getPotentialCells() {
        Set<Cell> neighbourCells = new HashSet<>(liveCells);
        for (Cell liveCell : liveCells) {
            neighbourCells.addAll(liveCell.getNeighbors());
        }
        return neighbourCells;
    }

    private int getLiveNeighboursCount(Cell cell) {
        Set<Cell> neighbourCells = new HashSet<>(cell.getNeighbors());
        int count = 0;

        for (Cell neighbourCell : neighbourCells) {
            if (liveCells.contains(neighbourCell)) count++;
        }
        return count;
    }

    public Grid evolve() {
        Set<Cell> nextGenLiveCells = new HashSet<>();
        for (Cell cell : getPotentialCells()) {
            int count = getLiveNeighboursCount(cell);
            boolean isLive = liveCells.contains(cell);
            if ((isLive && (count == 2 || count == 3)) || (!isLive && count == 3)) {
                nextGenLiveCells.add(cell);
            }
        }
        return new Grid(nextGenLiveCells);
    }
}
