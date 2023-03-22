package com.crazedout.gol;

public class TestConfig implements IConfig {

    int cols,rows,size,speed,seed;

    TestConfig(){

    }

    TestConfig(int cols, int rows, int size, int seed, int speed){
        this.cols=cols;
        this.rows=rows;
        this.size=size;
        this.speed=speed;
        this.seed=seed;
    }

    public int getCols(){
        return cols;
    }
    public int getRows(){
        return rows;
    }
    public int getSize(){
        return size;
    }
    public int getSpeed(){
        return speed;
    }
    public int getSeed(){
        return seed;
    }
    public void setCols(int cols){}
    public void setRows(int rows){}
    public void setSize(int size){}
    public void setSpeed(int speed){}
    public void setSeed(int seed){}

}
