package com.company;

import com.company.components.Config;
import com.company.components.MenuPanel;
import com.company.components.MySlider;
import com.company.components.PaintPanel;
import com.company.listeners.MenuBarListener;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Gui {

    public Gui() {
        JFrame frame = new JFrame();

        Config config = new Config();
        PaintPanel panel = new PaintPanel(config);
        MenuPanel menu = new MenuPanel(config);

        JMenuBar mbar = new JMenuBar();
        frame.setJMenuBar(mbar);

        JMenu menuUp = new JMenu("First");
        mbar.add(menuUp);

        JMenuItem firstItem = new JMenuItem("Close");
        menuUp.add(firstItem);
        firstItem.addActionListener(new MenuBarListener());
        JRadioButton rbut = new JRadioButton("Click me");
        menuUp.add(rbut);
        rbut.setSelected(true);

       /* PopupMenu pm = new PopupMenu();
        MenuItem pmitem = new MenuItem("pm item");
        pm.add(pmitem);
        frame.add(pm);
*/
        frame.add("Center",panel);
        frame.add("South", new MySlider(panel.getMouseListener()));
        frame.add("North",menu);

        frame.setMinimumSize(new Dimension(700,700));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
