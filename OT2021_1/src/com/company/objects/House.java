package com.company.objects;

import lombok.Data;

import java.awt.*;

@Data
public class House {
    private Color c;
    private int x,y;
    private int rectSize;
    private int[] xCords;
    private int[] yCords;
    public House(int x, int y, Color c) {
        rectSize = 25;
        this.x = x;
        this.y = y;
        this.c = c;
        xCords = new int[] {0,0,0};
        yCords = new int[] {0,0,0};
        setPolygon();
    }
    public void setPolygon() {
        xCords[0] = x - 12;
        xCords[1] = x;
        xCords[2] = x + 12;
        yCords[0] = y;
        yCords[1] = y - 25;
        yCords[2] = y;
    }
    public int getRectX() {
        return xCords[0];
    }
    public int getRectY() {
        return yCords[0];
    }

    public void drawHouse(Graphics g) {
        g.setColor(c);
        g.fillPolygon(xCords, yCords, 3);
        g.fillRect(getRectX(), getRectY(), rectSize, rectSize);
    }
}
