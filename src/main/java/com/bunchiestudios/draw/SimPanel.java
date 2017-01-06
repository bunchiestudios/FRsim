package com.bunchiestudios.draw;


import com.bunchiestudios.sim.Robot;
import com.bunchiestudios.sim.StandardRobot;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Created by rdelfin on 12/21/16.
 */
public class SimPanel extends JPanel {

    DrawableStandardRobot robot;

    public SimPanel() {
        super();
        setBackground(Color.WHITE);
        robot = new DrawableStandardRobot((StandardRobot) Robot.getInstance());
    }

    public void paintComponent(Graphics g)  // draw graphics in the panel
    {
        int width = getWidth();
        int height = getHeight();

        super.paintComponent(g);

        robot.setPpm((double)width/10.0);
        robot.draw(new Point(0, 0), new Point(width, height), g);
    }
}
