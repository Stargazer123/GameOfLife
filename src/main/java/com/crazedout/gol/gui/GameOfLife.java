package com.crazedout.gol.gui;

import javax.swing.*;

/**
 * Implementation of Conway's Game of Life
 * @author Fredrik Roos 2023
 */

public class GameOfLife extends JFrame implements IConfigListener {

    public GameOfLife(){
        super("GameOfLife");
    }

    @Override
    public void configChanged() {
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] argv) throws Exception{

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        GamePanel gamePanel = new GamePanel();
        Config.getInstance().addConfigListener(gamePanel);
        ControlPanel controlPanel = new ControlPanel(gamePanel);

        GameOfLife gof = new GameOfLife();
        Config.getInstance().addConfigListener(gof);
        gof.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gof.add("Center", gamePanel);
        gof.add("South", controlPanel);
        gof.pack();
        gof.setLocationRelativeTo(null);
        gof.setVisible(true);
    }

}
