package com.company.listeners;

import com.company.components.Config;
import com.company.components.MySlider;
import com.company.components.PaintPanel;
import com.company.objects.House;
import com.company.objects.Road;
import com.company.objects.Tree;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyMouseListener implements MouseListener, MouseMotionListener, ChangeListener {
    private final Config config;
    private final ArrayList<Tree> trees;
    private final ArrayList<House> houses;
    private final PaintPanel panel;
    public MyMouseListener(PaintPanel panel, Config config, ArrayList<Tree> trees, ArrayList<House> houses) {
        this.trees = trees;
        this.houses = houses;
        this.config = config;
        this.panel = panel;

    }
    @Override
    public void stateChanged(ChangeEvent e) {
        if (config.isChangeSize() && (panel.getSelHouse() != null || panel.getSelTree() !=null)) {
            MySlider s = (MySlider) e.getSource();
            int size = s.getValue();
            if (panel.getSelTree() != null) {
                panel.getSelTree().setOvalWidth(size);
            }
            if (panel.getSelHouse() != null) {

            }
        }
        panel.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (config.isTree()) {
            Color c = config.getColors().get(config.getCounter()%3);
            trees.add(new Tree(e.getX(), e.getY(), c));
            config.setCounter(config.getCounter() + 1);
        }
        else if (config.isHouse()) {
            Color c = config.getColors().get(config.getCounter()%3);
            houses.add(new House(e.getX(), e.getY(), c));
            config.setCounter(config.getCounter() + 1);
        }
        else if (config.isChangeSize()) {
            checkObject(e.getX(), e.getY());
            panel.setCurRoad(null);

        }
        panel.repaint();
    }

    public void checkObject(int x, int y) {
        for (Tree tree : trees) {
            Rectangle r = new Rectangle(tree.getX()-(tree.getOvalWidth() / 2), tree.getY()-(tree.getOvalWidth() / 2), tree.getOvalWidth(), (tree.getOvalHeight()/2)*3);
            if (r.contains(x, y)) {
                panel.setSelTree(tree);
                panel.setCurRoad(new Road());
                return;
            }
        }
        for (House house : houses) {
            Rectangle r = new Rectangle(house.getX()-25, house.getY()-25, house.getRectSize()*2, house.getRectSize()*2);
            if (r.contains(x, y)) {
                panel.setSelHouse(house);
                panel.setCurRoad(new Road());
                return;
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (config.isTree()) {
            panel.getCurTree().setX(e.getX());
            panel.getCurTree().setY(e.getY());
            panel.getCurTree().adjustCords();
        }
        if (config.isHouse()) {
            panel.getCurHouse().setX(e.getX());
            panel.getCurHouse().setY(e.getY());
            panel.getCurHouse().setPolygon();
        }
        panel.repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (config.isRoad()) {
             checkObject(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (config.isChangeSize()) return;
        if (panel.getSelTree() != null) {
            System.out.println(panel.getSelTree());
            panel.getCurRoad().setX1(panel.getSelTree().getX());
            panel.getCurRoad().setY1(panel.getSelTree().getY());
            panel.getCurRoad().setX2(e.getX());
            panel.getCurRoad().setY2(e.getY());
        }
        else if (panel.getSelHouse() != null) {
            panel.getCurRoad().setX1(panel.getSelHouse().getX());
            panel.getCurRoad().setY1(panel.getSelHouse().getY());
            panel.getCurRoad().setX2(e.getX());
            panel.getCurRoad().setY2(e.getY());
        }
        panel.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (panel.getCurRoad() != null) {
            checkObject(e.getX(), e.getY());
            if (panel.getSelTree() != null && panel.getSelHouse() != null) {
                panel.getCurRoad().setX1(panel.getSelTree().getX());
                panel.getCurRoad().setY1(panel.getSelTree().getY());
                panel.getCurRoad().setX2(panel.getSelHouse().getX());
                panel.getCurRoad().setY2(panel.getSelHouse().getY());
                panel.getRoads().add(panel.getCurRoad());
            }
            panel.setCurRoad(null);
            panel.setSelTree(null);
            panel.setSelHouse(null);
        }
        panel.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }


}
