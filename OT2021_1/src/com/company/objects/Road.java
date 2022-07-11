package com.company.objects;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
@Getter @Setter
public class Road {
    private Color c;
    private int x1, y1;
    private int x2, y2;
    public Road() {
        c = Color.BLACK;
    }
    public void drawRoad(Graphics g) {
        g.setColor(c);
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}
