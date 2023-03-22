package com.crazedout.gol.gui;

import com.crazedout.gol.IConfig;

import java.util.ArrayList;
import java.util.List;

public class Config implements IConfig {

    private static Config instance;

    private int cols = 100;
    private int rows = 60;
    private int size = 8;
    private int seed = 6;
    private int speed = 200;
    private List<IConfigListener> listeners;

    private Config(){
        listeners = new ArrayList<>();
    }

    public void addConfigListener(IConfigListener l){
        this.listeners.add(l);
    }

    public void removeConfigListener(IConfigListener l){
        this.listeners.remove(l);
    }

    public void fireConfigChanged(){
        for(IConfigListener l:listeners){
            l.configChanged();
        }
    }

    public static Config getInstance(){
        if(instance==null){
            instance = new Config();
        }
        return instance;
    }

    public void setCols(int cols){
        this.cols=cols;
    }

    public int getCols(){
        return this.cols;
    }

    public void setRows(int rows){
        this.rows=rows;
    }

    public int getRows(){
        return this.rows;
    }

    public void setSize(int size){
        this.size=size;
    }

    public int getSize(){
        return this.size;
    }

    public void setSeed(int seed){
        this.seed=seed;
    }

    public int getSeed(){
        return this.seed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
