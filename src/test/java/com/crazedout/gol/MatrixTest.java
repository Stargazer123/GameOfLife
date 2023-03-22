package com.crazedout.gol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    Matrix matrix;
    private static final int TESTCELL = 99;
    private static final int TESTCELL2 = 100;
    private int cols = 100;
    private int rows = 100;
    private TestConfig testConfig;


    @BeforeEach
    void setUp() {
        testConfig = new TestConfig(cols, rows, 0, -1, 0);
        matrix = new Matrix(testConfig);
        matrix.reset();
        matrix.getCells().get(TESTCELL2).setAlive(true);
    }

    @Test
    void initTest(){
        Matrix matrix = new Matrix();
        TestConfig t = new TestConfig(50,50,10,10,100);
        matrix.setConfig(t);
        matrix.reset();
        assertTrue(matrix.getCells().size()==50*50);
    }

    @Test
    void testCells() {
        matrix.reset();
        assertFalse(matrix.getCellStatus(matrix.getCells().get(TESTCELL)));
        assertFalse(matrix.getCellStatus(matrix.getCells().get(TESTCELL2)));
        matrix.getCells().get(TESTCELL).setAlive(true);
        assertTrue(matrix.getBuddyCount(matrix.getCells().get(TESTCELL))==0);
        assertTrue(matrix.getBuddyCount(matrix.getCells().get(TESTCELL2))==1);
    }

    @Test
    void testConfig(){
        assertTrue(matrix.getConfig().equals(testConfig));
    }

    @Test
    void testGetCell(){
        assertTrue(matrix.getCells().size()==cols*rows);
    }

    @Test
    void testSpawn(){
        matrix.spawnGeneration(matrix.getCells());
    }

    @Test
    void testLevel(){
        matrix.nextLevel();
        matrix.nextLevel();
        assertTrue(matrix.getGeneration()==2);
    }

    @Test
    void testCellStatus(){
        assertFalse(matrix.getCellStatus(matrix.getCells().get(TESTCELL2)));
    }

    @Test
    void testRandomize(){
        matrix.randomize(matrix.getCells());
    }

    @Test
    void setConfig(){
        TestConfig t = new TestConfig(50,50,10,10,100);
        matrix.setConfig(t);
        matrix.reset();
        assertTrue(matrix.getCells().size()==50*50);
    }

}