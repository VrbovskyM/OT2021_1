package com.company.components;

import com.company.listeners.MyMouseListener;

import javax.swing.*;

public class MySlider extends JSlider {

    public MySlider(MyMouseListener mouseListener) {
        super(0,1000,10);
        setFocusable(false);
        setPaintTrack(true);
        setPaintTicks(true);
        setPaintLabels(true);
        //setMajorTickSpacing(100);
        addChangeListener(mouseListener);

    }

}
