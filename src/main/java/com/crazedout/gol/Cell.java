package com.crazedout.gol;

/**
 * Defines a 'cell' in Conway's Game of Life.
 * It can be "on" or "of" depending on it's neighbours status.
 * @author Fredrik Roos 2023
 */

public class Cell {

    private boolean alive;
    private int x,y,index;

    public Cell(Cell c, boolean alive){
        this(c.x,c.y,c.index);
        this.alive=alive;
    }

    public Cell(int x, int y, int index){
        this.index=index;
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getIndex(){
        return this.index;
    }

    public boolean isAlive(){
        return this.alive;
    }

    public void setAlive(boolean alive){
        this.alive=alive;
    }
}
