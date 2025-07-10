package com.gol.gameoflife;

import com.gol.gameoflife.cell.Cell;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Get input
        Scanner scanner = new Scanner(System.in);
        Set<Cell> initialCells = InputParser.parseInitialCells(scanner);

        // Create initial grid
        Grid initialGrid = new Grid(initialCells);
        GameOfLife engine = new GameOfLife();
        // Compute next generation
        Grid nextGen = engine.nextGeneration(initialGrid);

        // Display output
        OutputPrinter.printLiveCells(nextGen.liveCells());
    }
}
