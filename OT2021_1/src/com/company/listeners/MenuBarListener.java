package com.company.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarListener implements ActionListener {

    public MenuBarListener() {
        super();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
