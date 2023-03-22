package com.crazedout.gol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {

    private Matrix matrix;
    private int cols=24;
    private int rows=24;
    private static final int TESTCELL = 99;

    @BeforeEach
    void setUp() {
        matrix = new Matrix(new TestConfig(100, 100, 0, -1, 0));
        matrix.create();
        matrix.getCells().get(TESTCELL+1).setAlive(true);
        matrix.getCells().get(TESTCELL-1).setAlive(true);
    }

    @Test
    void getBuddyCount() {
        int cnt = matrix.getBuddyCount(matrix.getCells().get(TESTCELL));
        assert(cnt==2);
    }

    @Test
    void isAlive() {
        assert(!matrix.getCells().get(TESTCELL).isAlive());
    }

    @Test
    void setAlive() {
        matrix.getCells().get(TESTCELL).setAlive(true);
        assert(matrix.getCells().get(TESTCELL).isAlive());
    }
}