package com.gol.gameoflife;

import com.gol.gameoflife.cell.Cell;

import java.util.Set;

public class OutputPrinter {
    public static void printLiveCells(Set<Cell> liveCells) {
        for (Cell cell : liveCells) {
            System.out.println(cell);
        }
    }
}
