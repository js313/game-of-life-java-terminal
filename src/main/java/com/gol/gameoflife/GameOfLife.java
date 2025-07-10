package com.gol.gameoflife;

public class GameOfLife {
    public Grid nextGeneration(Grid seedGrid) {
        return seedGrid.evolve();
    }
}
