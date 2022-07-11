package com.company.components;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;

public class Config {
    @Getter @Setter
    private boolean tree, house, road, changeSize;
    @Getter @Setter
    private ArrayList<Color> colors;
    @Getter @Setter
    private int counter;
    public Config() {
        tree = true;
        house = false;
        colors = new ArrayList<>();
        addColors();
    }
    private void addColors() {
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.CYAN);
    }
    public Color selectNextColor() {
        return colors.get(counter%3);
    }
}
