package com.gol.gameoflife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class GameOfLifeTest {
    @Test
    public void testBlockStillLife() {
        Set<Cell> initial = Set.of(
                CellFactory.get(1, 1),
                CellFactory.get(1, 2),
                CellFactory.get(2, 1),
                CellFactory.get(2, 2)
        );

        Grid grid = new Grid(initial);
        GameOfLife engine = new GameOfLife();

        Grid next = engine.nextGeneration(grid);

        Assertions.assertEquals(initial, next.getLiveCells());
    }

    @Test
    public void testBlinkerOscillator() {
        Set<Cell> initial = Set.of(
                CellFactory.get(1, 0),
                CellFactory.get(1, 1),
                CellFactory.get(1, 2)
        );

        Set<Cell> expectedNext = Set.of(
                CellFactory.get(0, 1),
                CellFactory.get(1, 1),
                CellFactory.get(2, 1)
        );

        Grid grid = new Grid(initial);
        GameOfLife engine = new GameOfLife();

        Grid next = engine.nextGeneration(grid);

        Assertions.assertEquals(expectedNext, next.getLiveCells());
    }

    @Test
    public void testToadOscillator() {
        Set<Cell> initial = Set.of(
                CellFactory.get(1, 1),
                CellFactory.get(1, 2),
                CellFactory.get(1, 3),
                CellFactory.get(2, 2),
                CellFactory.get(2, 3),
                CellFactory.get(2, 4)
        );

        Set<Cell> expectedNext = Set.of(
                CellFactory.get(0, 2),
                CellFactory.get(1, 1),
                CellFactory.get(1, 4),
                CellFactory.get(2, 1),
                CellFactory.get(2, 4),
                CellFactory.get(3, 3)
        );

        Grid grid = new Grid(initial);
        GameOfLife engine = new GameOfLife();

        Grid next = engine.nextGeneration(grid);

        Assertions.assertEquals(expectedNext, next.getLiveCells());
    }

    @Test
    public void testUnderpopulationDies() {
        Set<Cell> initial = Set.of(
                CellFactory.get(2, 2)
        );

        Set<Cell> expected = Set.of();

        Grid grid = new Grid(initial);
        GameOfLife engine = new GameOfLife();

        Grid next = engine.nextGeneration(grid);

        Assertions.assertEquals(expected, next.getLiveCells());
    }

    @Test
    public void testOverpopulationDies() {
        Set<Cell> initial = Set.of(
                CellFactory.get(1, 1),
                CellFactory.get(0, 0),
                CellFactory.get(0, 1),
                CellFactory.get(0, 2),
                CellFactory.get(1, 0)
        );

        Set<Cell> expected = Set.of(
                CellFactory.get(0, 0),
                CellFactory.get(1, 2),
                CellFactory.get(0, 2),
                CellFactory.get(1, 0),
                CellFactory.get(-1, 1)
        );

        Grid grid = new Grid(initial);
        GameOfLife engine = new GameOfLife();

        Grid next = engine.nextGeneration(grid);

        Assertions.assertEquals(expected, next.getLiveCells());
    }

    @Test
    public void testNegativeBounds() {
        Set<Cell> initial = Set.of(
                CellFactory.get(-2, -2),
                CellFactory.get(-1, -1),
                CellFactory.get(-1, -2),
                CellFactory.get(-1, -3),
                CellFactory.get(-2, -1),
                CellFactory.get(-2, -3),
                CellFactory.get(-3, -1),
                CellFactory.get(-3, -2),
                CellFactory.get(-3, -3)
        );

        Set<Cell> expected = Set.of(
                CellFactory.get(0, -2),
                CellFactory.get(-1, -3),
                CellFactory.get(-1, -1),
                CellFactory.get(-2, -4),
                CellFactory.get(-2, -0),
                CellFactory.get(-3, -3),
                CellFactory.get(-3, -1),
                CellFactory.get(-4, -2)
        );

        Grid grid = new Grid(initial);
        GameOfLife engine = new GameOfLife();

        Grid next = engine.nextGeneration(grid);

        Assertions.assertEquals(expected, next.getLiveCells());
    }

    @Test
    public void testReproductionOfDeadCell() {
        Set<Cell> initial = Set.of(
                CellFactory.get(0, 1),
                CellFactory.get(1, 0),
                CellFactory.get(1, 2)
        );

        // (1,1) is dead with 3 neighbors → becomes alive
        Set<Cell> expected = Set.of(
                CellFactory.get(1, 1)
        );

        Grid grid = new Grid(initial);
        GameOfLife engine = new GameOfLife();

        Grid next = engine.nextGeneration(grid);

        Assertions.assertEquals(expected, next.getLiveCells());
    }

    @Test
    public void testEmptyGridStaysEmpty() {
        Grid grid = new Grid(Set.of());
        GameOfLife engine = new GameOfLife();

        Grid next = engine.nextGeneration(grid);

        Assertions.assertTrue(next.getLiveCells().isEmpty());
    }
}