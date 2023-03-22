package com.crazedout.gol.gui;

import javax.swing.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ConfigDialog {

    private static ConfigDialog instance;

    JTextField colsText,rowsText,sizeText,seedText,speedText;

    private ConfigDialog(){
        colsText = new JTextField(""+ Config.getInstance().getCols());
        rowsText = new JTextField(""+ Config.getInstance().getRows());
        sizeText = new JTextField(""+ Config.getInstance().getSize());
        seedText = new JTextField(""+ Config.getInstance().getSeed());
        speedText = new JTextField(""+ Config.getInstance().getSpeed());
    }

    public static ConfigDialog getInstance(){
        if(instance==null){
            instance = new ConfigDialog();
        }
        return instance;
    }

    public static void openDialog() {
        int cols,rows,size,seed,speed;
        Object[] config = {
                "Cols:", getInstance().colsText,
                "Rows:", getInstance().rowsText,
                "Size:", getInstance().sizeText,
                "Speed:", getInstance().speedText,
                "Seed:", getInstance().seedText,
        };
        int option = JOptionPane.showConfirmDialog(null, config, "GOF Config", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                cols = Integer.parseInt(getInstance().colsText.getText());
                rows = Integer.parseInt(getInstance().rowsText.getText());
                size = Integer.parseInt(getInstance().sizeText.getText());
                seed = Integer.parseInt(getInstance().seedText.getText());
                speed = Integer.parseInt(getInstance().speedText.getText());
                Config.getInstance().setCols(cols);
                Config.getInstance().setRows(rows);
                Config.getInstance().setSize(size);
                Config.getInstance().setSeed(seed);
                Config.getInstance().setSpeed(speed);
                Config.getInstance().fireConfigChanged();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Bad input: reverting to prevoius configuration", ex.getMessage(), ERROR_MESSAGE);
            }

        }
    }
}
