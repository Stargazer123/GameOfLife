package com.crazedout.gol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    Matrix matrix;
    private static final int TESTCELL = 99;
    private static final int TESTCELL2 = 100;

    @BeforeEach
    void setUp() {
        matrix = new Matrix(new TestConfig(100, 100, 0, -1, 0));
        matrix.reset();
        matrix.getCells().get(TESTCELL2).setAlive(true);
    }

    @Test
    void testCells() {
        matrix.getCellStatus(matrix.getCells().get(TESTCELL));
        matrix.getCellStatus(matrix.getCells().get(TESTCELL2));
        matrix.getBuddyCount(matrix.getCells().get(TESTCELL));
        matrix.getBuddyCount(matrix.getCells().get(TESTCELL2));
    }

    @Test
    void testSpawn(){
        matrix.spawnGeneration(matrix.getCells());
    }

    @Test
    void testLevel(){
        matrix.nextLevel();
    }

    @Test
    void testRandomize(){
        matrix.randomize(matrix.getCells());
    }

}