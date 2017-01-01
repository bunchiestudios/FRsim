package com.bunchiestudios.draw;

import com.bunchiestudios.sim.StandardRobot;
import com.bunchiestudios.util.Vector2;

import java.awt.*;

/**
 * Created by rdelfin on 12/26/16.
 */
public class DrawableStandardRobot implements Drawable {
    StandardRobot robot;
    double ppm;

    public DrawableStandardRobot(StandardRobot robot, double pixelsPerMeter) {
        this.robot = robot;
        this.ppm = pixelsPerMeter;
    }

    @Override
    public void draw(Point screenStart, Point screenSize, Graphics g) {
        Vector2 pixelSize = new Vector2(robot.getWidth(), robot.getHeight()).scale(ppm);
        Vector2 pixelPos = robot.getPosition().scale(ppm).add(new Vector2(screenStart.x, screenStart.y));

        g.drawRect((int)pixelPos.x, (int)pixelPos.y, (int)pixelSize.x, (int)pixelPos.y);
    }
}
