package com.gol.gameoflife;

import java.util.HashSet;
import java.util.Set;

public class GameOfLife {
    public Grid nextGeneration(Grid seedGrid) {
        Set<Cell> nextGenLiveCells = new HashSet<>();
        Set<Cell> currentGenLiveCells = seedGrid.getLiveCells();
        Set<Cell> potentialCells = seedGrid.getPotentialCells();

        for(Cell potentialCell: potentialCells) {
            boolean isLive = currentGenLiveCells.contains(potentialCell);
            int liveNeighboursCount = seedGrid.getLiveNeighboursCount(potentialCell);

            if(isLive) {
                // reason why checking '3' and '4' live neighbours
                // if isLive, liveNeighbourCount includes this cell as well
                if(liveNeighboursCount==3||liveNeighboursCount==4) nextGenLiveCells.add(potentialCell);
            } else {
                if(liveNeighboursCount==3) nextGenLiveCells.add(potentialCell);
            }
        }

        return new Grid(nextGenLiveCells);
    }
}
