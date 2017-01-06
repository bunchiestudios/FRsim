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

    public DrawableStandardRobot(StandardRobot robot) {
        this.robot = robot;
    }

    public void setPpm(double ppm) {
        this.ppm = ppm;
    }

    @Override
    public void draw(Point screenStart, Point screenSize, Graphics g) {
        Vector2 pixelSize = new Vector2(robot.getWidth(), robot.getHeight()).scale(ppm);
        Vector2 pixelPos = robot.getPosition().scale(ppm).add(new Vector2(screenStart.x, screenStart.y));
        Vector2 upVector = new Vector2(0, -pixelSize.y).rotate(robot.getTheta());
        Vector2 rightVector = new Vector2(pixelSize.x, 0).rotate(robot.getTheta());

        Vector2 topLeft = pixelPos.add(upVector).add(rightVector.scale(-1));
        Vector2 topRight = pixelPos.add(upVector).add(rightVector);
        Vector2 bottomLeft = pixelPos.add(upVector.scale(-1)).add(rightVector.scale(-1));
        Vector2 bottomRight = pixelPos.add(upVector.scale(-1)).add(rightVector);

        g.setColor(new Color(255, 0, 0));
        g.fillPolygon(new Polygon(new int[]{(int)topLeft.x, (int)topRight.x, (int)bottomRight.x, (int)bottomLeft.x},
                new int[]{(int)topLeft.y, (int)topRight.y, (int)bottomRight.y, (int)bottomLeft.y},
                4));
        //g.fillRect((int)pixelPos.x, (int)pixelPos.y, (int)pixelSize.x, (int)pixelPos.y);
    }
}
