package com.crazedout.gol.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements ActionListener {

    JButton start,stop,reset,config;
    JCheckBox gridBox;
    IControls controls;

    public ControlPanel(IControls controls){
        super(new FlowLayout(FlowLayout.CENTER));
        this.controls=controls;
        start = new JButton("Start");
        start.addActionListener(this);
        reset = new JButton("Reset");
        reset.addActionListener(this);
        stop = new JButton("Stop");
        stop.addActionListener(this);
        config = new JButton("Config...");
        config.addActionListener(this);

        gridBox = new JCheckBox("Show grid:", controls.isGridVisible());
        gridBox.addActionListener(this);

        add(start);
        add(stop);
        add(reset);
        add(config);
        add(gridBox);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==start){
            controls.start();
        }else if(actionEvent.getSource()==stop){
            controls.stop();
        }else if(actionEvent.getSource()==reset){
            controls.reset();
        }else if(actionEvent.getSource()==gridBox){
            controls.setGridVisible(gridBox.isSelected());
        }else if(actionEvent.getSource()==config){
            ConfigDialog.openDialog();
        }
    }
}
