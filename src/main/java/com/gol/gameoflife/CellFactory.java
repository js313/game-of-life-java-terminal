package com.gol.gameoflife;
import java.util.HashMap;
import java.util.Map;

public class CellFactory {
    private static final Map<String, Cell> cellPool = new HashMap<>();

    public static Cell get(int x, int y) {
        String key = x + "," + y;
        return cellPool.computeIfAbsent(key, k -> new Cell(x, y));
    }
}
