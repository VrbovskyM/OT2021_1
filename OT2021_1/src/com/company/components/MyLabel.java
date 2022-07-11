package com.company.components;

import javax.swing.*;

public class MyLabel extends JLabel {

    public MyLabel (String label, Config config) {
        super(label);
        this.setFocusable(false);
        this.setOpaque(true);
        setBackground(config.getColors().get(0));
    }
}
