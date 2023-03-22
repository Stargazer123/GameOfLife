package com.crazedout.gol;

public class TestConfig implements IConfig {

    private int cols,rows,size,speed,seed;

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
        return this.cols;
    }
    public int getRows(){
        return this.rows;
    }
    public int getSize(){
        return this.size;
    }
    public int getSpeed(){
        return this.speed;
    }
    public int getSeed(){
        return this.seed;
    }

}
