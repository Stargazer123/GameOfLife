package com.crazedout.gol.gui;

import com.crazedout.gol.Cell;
import com.crazedout.gol.IConfig;
import com.crazedout.gol.Matrix;

import javax.swing.*;
import java.awt.*;

public class SimpleGol extends JPanel {

    private Matrix matrix;
    private Thread runner;

    public SimpleGol(){
        matrix = new Matrix();
        matrix.setConfig(Config.getInstance());
        matrix.reset();
        runner = new Thread(new Runnable() {
            @Override
            public void run() {
                while(runner!=null){
                    try{
                        matrix.nextLevel();
                        repaint();
                        Thread.sleep(matrix.getConfig().getSpeed());
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        });
        runner.start();
    }

    @Override
    public synchronized Dimension getPreferredSize(){
        return new Dimension(matrix.getConfig().getCols()* matrix.getConfig().getSize(),
                (matrix.getConfig().getRows()* matrix.getConfig().getSize())+40);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        if(matrix!=null && matrix.getCells() !=null){
            for(Cell c:matrix.getCells()){
                if(c.isAlive()){
                    g.fillRect(c.getX(),c.getY(), matrix.getConfig().getSize(),
                            matrix.getConfig().getSize());
                }
            }
        }
    }

    public static void main(String[] argv){

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new SimpleGol());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);

    }
}
