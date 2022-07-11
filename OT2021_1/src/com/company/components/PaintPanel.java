package com.company.components;

import com.company.listeners.MyMouseListener;
import com.company.objects.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
@Data
public class PaintPanel extends JPanel {
    private final ArrayList<Tree> trees;
    private final ArrayList<House> houses;
    private ArrayList<Road> roads;
    private final Config config;
    private Tree curTree;
    private House curHouse;
    private Road curRoad;
    private Tree selTree;
    private House selHouse;
    private MyMouseListener mouseListener;
    public PaintPanel(Config config) {
        trees = new ArrayList<>();
        houses = new ArrayList<>();
        roads = new ArrayList<>();
        this.config = config;
        mouseListener = new MyMouseListener(this, config, trees, houses);
        this.addMouseMotionListener(mouseListener);
        this.addMouseListener(mouseListener);

        curTree = new Tree(-100,-100,config.getColors().get(config.getCounter()%3));
        curHouse = new House(-100,-100,config.getColors().get(config.getCounter()%3));
        curRoad = new Road();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (config.isRoad() && curRoad != null) {
            curRoad.drawRoad(g);
        }
        else if (config.isTree()) {
            Color c = new Color(config.selectNextColor().getRed(), config.selectNextColor().getGreen(), config.selectNextColor().getBlue(), 90);
            curTree.setC(c);
            curTree.drawTree(g);
        }
        else if (config.isHouse()) {
            Color c = new Color(config.selectNextColor().getRed(), config.selectNextColor().getGreen(), config.selectNextColor().getBlue(), 90);
            curHouse.setC(c);
            curHouse.drawHouse(g);
        }

        for (Tree tree: trees) {
            tree.drawTree(g);
        }
        for (House house: houses) {
            house.drawHouse(g);
        }
        for (Road road : roads) {
            road.drawRoad(g);
        }
    }
}
