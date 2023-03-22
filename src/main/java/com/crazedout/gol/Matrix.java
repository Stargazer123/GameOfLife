package com.crazedout.gol;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the Conway's Game of Life 2D matrix.
 * @author Fredrik Roos 2023
 */

public class Matrix {

    private List<Cell> cells;
    private int generation;
    private IConfig config;

    public Matrix(){

    }

    public Matrix(IConfig config){
        this.config = config;
    }

    public void setConfig(IConfig config){
        this.config=config;
    }

    public IConfig getConfig(){
        return this.config;
    }

    public void reset(){
        randomize(create());
    }

    public int getGeneration(){
        return this.generation;
    }

    public void nextLevel(){
        cells = spawnGeneration(cells);
    }

    public final List<Cell> getCells(){
        return this.cells;
    }

    boolean getCellStatus(final Cell c){
        int cnt = getBuddyCount(c);
        if(c.isAlive()){
            if(cnt<2) return false;
            else return cnt == 2 || cnt == 3;
        }else{
            return cnt == 3;
        }
    }

    int getBuddyCount(Cell c){
        int count=0;
        int cols = config.getCols();
        int[] mat = {c.getIndex()-cols-1,c.getIndex()-cols,c.getIndex()-cols+1,
                c.getIndex()-1,c.getIndex()+1,
                c.getIndex()+(cols-1),c.getIndex()+cols,c.getIndex()+cols+1};

        for (int pos : mat) {
            if (pos < 0 || pos > cells.size() - 1) continue;
            if (cells.get(pos).isAlive()) {
                count++;
            }
        }
        return count;
    }

    List<Cell> spawnGeneration(List<Cell> currentCells){
        List<Cell> newCells = new ArrayList<>();
        for(Cell c:currentCells){
            newCells.add(new Cell(c,getCellStatus(c)));
        }
        this.generation++;
        return newCells;
    }

    List<Cell> create() {
        int rows = config.getRows();
        int cols = config.getCols();
        int size = config.getSize();
        List<Cell> matrix = new ArrayList<>();
        int n = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix.add(new Cell((c*size),(r*size),n++));
            }
        }
        this.generation=0;
        this.cells = matrix;
        return matrix;
    }

    void randomize(List<Cell> cells){
        for (int i = 0; i < config.getSeed()*200; i++) {
            int x = (int) (Math.random() * config.getCols());
            int y = (int) (Math.random() * config.getRows());
            cells.get(y * config.getCols() + x).setAlive(true);
        }
    }

}
