package com.company.listeners;

import com.company.components.Config;
import com.company.components.MyLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private Config config;
    private MyLabel label;
    public ButtonListener(Config config, MyLabel label) {
        this.config = config;
        this.label = label;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Tree":
                config.setTree(true);
                config.setHouse(false);
                config.setRoad(false);
                config.setChangeSize(false);
                label.setText("Tree");
                break;
            case "House":
                config.setTree(false);
                config.setHouse(true);
                config.setRoad(false);
                config.setChangeSize(false);
                label.setText("House");
                break;
            case "Road":
                config.setHouse(false);
                config.setTree(false);
                config.setRoad(true);
                config.setChangeSize(false);
                label.setText("Road");
                break;
            case "Change Size":
                config.setChangeSize(true);
                config.setHouse(false);
                config.setTree(false);
                config.setRoad(false);
                label.setText("ChangeSize");
                break;
        }
        if (e.getSource().equals("Male")) {
            System.out.println("Ahoj");
        }
    }
}
