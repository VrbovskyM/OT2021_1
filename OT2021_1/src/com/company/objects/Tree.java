package com.company.objects;

import lombok.Data;

import java.awt.*;

@Data
public class Tree {
    private int x, y;
    private int centerX, centerY;
    private int ovalHeight;
    private int ovalWidth;
    private int rectHeight;
    private int rectWidth;
    private Color c;
    public Tree(int x, int y, Color c) {
        ovalHeight = 50/3*2;
        ovalWidth = 50;
        rectHeight = 50/2;
        rectWidth = 50/3;
        this.x = x;
        this.y = y;
        adjustCords();
        this.c = c;
    }

    public void adjustCords() {
        centerX = x - (ovalWidth / 2);
        centerY = y - (ovalWidth / 2);
        ovalHeight = ovalWidth/3*2;
        rectHeight = ovalWidth / 2;
        rectWidth = ovalWidth / 3;
    }
    public int getRectX() {
        return centerX + (ovalWidth / 3);
    }
    public int getRectY() {
        return centerY + (ovalHeight/3*2);
    }
    public void drawTree(Graphics g) {
        adjustCords();
        g.setColor(c);
        g.fillOval(getCenterX(), getCenterY(), getOvalWidth(), getOvalHeight());
        g.fillRect(getRectX(), getRectY(), getRectWidth(), getRectHeight());
    }
}
