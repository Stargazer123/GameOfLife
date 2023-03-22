package com.crazedout.gol.gui;

import com.crazedout.gol.IConfig;

public interface IConfigMutable extends IConfig {

    void setCols(int cols);
    void setRows(int rows);
    void setSize(int size);
    void setSpeed(int speed);
    void setSeed(int seed);

}
