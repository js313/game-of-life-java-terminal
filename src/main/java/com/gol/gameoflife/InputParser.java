package com.gol.gameoflife;

import com.gol.gameoflife.cell.Cell;
import com.gol.gameoflife.cell.CellFactory;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputParser {
    public static Set<Cell> parseInitialCells(Scanner scanner) {
        Set<Cell> initialCells = new HashSet<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break;

            // Check valid input format
            try {
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());
                initialCells.add(CellFactory.get(x, y));
            } catch (Exception e) {
                System.err.println("Invalid input: " + line);
            }
        }
        return initialCells;
    }
}
