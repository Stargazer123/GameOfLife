package com.crazedout.gol.gui;

import com.crazedout.gol.Cell;
import com.crazedout.gol.Matrix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GamePanel extends JPanel implements Runnable, IControls, IConfigListener {

    private Matrix matrix;
    private Thread runner;
    private boolean showGrid=true;

    public GamePanel(){
        super(null);
        setBackground(Color.WHITE);
        this.matrix = new Matrix(Config.getInstance());
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                runner = null;
                matrix.getConfig().setCols(getWidth() / matrix.getConfig().getSize());
                matrix.getConfig().setRows((getHeight() / matrix.getConfig().getSize())-4);
                matrix.reset();
            }
        });
    }

    public void start(){
        this.runner = new Thread(this);
        this.runner.start();
    }

    public void stop(){
        runner = null;
    }

    public void reset(){
        this.runner = null;
        this.matrix.reset();
        repaint();
    }

    @Override
    public void configChanged(){
        reset();
    }

    public boolean isGridVisible(){
        return this.showGrid;
    }

    public void setGridVisible(boolean visible){
        this.showGrid=visible;
        repaint();
    }

    @Override
    public void run(){

        while(runner!=null){
            try{
                Thread.sleep(matrix.getConfig().getSpeed());
                tick();
                repaint();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    private void tick(){
        matrix.nextLevel();
    }

    @Override
    public synchronized Dimension getPreferredSize(){
        return new Dimension(matrix.getConfig().getCols()* matrix.getConfig().getSize(),
                (matrix.getConfig().getRows()* matrix.getConfig().getSize())+40);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        String genString = "Generation:" + matrix.getGeneration();
        g.setColor(Color.GRAY);
        if(matrix!=null && matrix.getCells() !=null){
            for(Cell c:matrix.getCells()){
                if(c.isAlive()){
                    g.fillRect(c.getX(),c.getY(), matrix.getConfig().getSize(),
                            matrix.getConfig().getSize());
                }else if(showGrid){
                    g.drawRect(c.getX(),c.getY(), matrix.getConfig().getSize(),
                            matrix.getConfig().getSize());
                }
            }
        }
        g.setColor(Color.BLACK);
        g.drawString(genString, (getWidth()/2)-g.getFontMetrics().stringWidth(genString)/2,
                getHeight()-g.getFontMetrics().getHeight());

    }
}

