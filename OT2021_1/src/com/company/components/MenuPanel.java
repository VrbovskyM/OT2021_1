package com.company.components;

import com.company.listeners.ButtonListener;
import com.company.listeners.RadioButtonListener;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public MenuPanel(Config config) {
        super();
        this.setLayout(new GridLayout());
        MyLabel label = new MyLabel("Tree", config);
        ButtonListener buttonListener = new ButtonListener(config, label);
        MyButton tree = new MyButton("Tree", buttonListener);
        MyButton house = new MyButton("House",buttonListener);
        MyButton road = new MyButton("Road", buttonListener);
        MyButton changeSize = new MyButton("Change Size", buttonListener);

        RadioButtonListener radioButtonListener = new RadioButtonListener(config, label);
        JRadioButton radioButton1 = new JRadioButton("Tree");
        radioButton1.setSelected(true);
        JRadioButton radioButton2 = new JRadioButton("House");
        radioButton1.addActionListener(radioButtonListener);
        radioButton2.addActionListener(radioButtonListener);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);


        add(tree);
        add(house);
        add(road);
        add(radioButton1);
        add(radioButton2);
        add(changeSize);
        add(label);

    }
}
