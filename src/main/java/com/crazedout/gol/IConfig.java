package com.crazedout.gol;

public interface IConfig {

    int getRows();
    int getCols();
    int getSize();
    int getSeed();
    int getSpeed();

    void setCols(int cols);
    void setRows(int rows);
    void setSize(int size);
    void setSpeed(int speed);
    void setSeed(int seed);

}
