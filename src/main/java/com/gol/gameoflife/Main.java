package com.gol.gameoflife;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Cell> initialCells = new HashSet<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break;
            String[] parts = line.split(",");
            initialCells.add(new Cell(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim())));
        }

        Grid initialGrid = new Grid(initialCells);
        GameOfLife engine = new GameOfLife();
        Grid nextGen = engine.nextGeneration(initialGrid);

        for (Cell cell : nextGen.getLiveCells()) {
            System.out.println(cell);
        }
    }
}
