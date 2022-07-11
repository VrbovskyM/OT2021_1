package com.company.components;

import com.company.listeners.ButtonListener;

import javax.swing.*;

public class MyButton extends JButton {

    public MyButton(String name, ButtonListener buttonListener) {
        super(name);
        this.setFocusable(false);
        this.addActionListener(buttonListener);
    }
}
