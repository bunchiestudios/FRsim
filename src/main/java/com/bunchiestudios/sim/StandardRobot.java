package com.bunchiestudios.sim;

import com.bunchiestudios.util.Util;
import com.bunchiestudios.util.Vector2;

/**
 * Created by rdelfin on 12/18/16.
 */
public class StandardRobot extends Robot {

    private Motor leftMotor;
    private Motor rightMotor;

    private double width, height, ts;

    /**
     * Main constructor for the robot. Initializes a robot with no devices, at a starting position
     * and angle. It creates a left motor on port 1 and right motor on port 2.
     *
     * @param startPosition The initial position of the robot.
     * @param theta         Initial angle of the robot
     */
    public StandardRobot(Vector2 startPosition, double theta, double width, double height) {
        super(startPosition, theta);

        this.leftMotor = new Motor();
        this.rightMotor = new Motor();

        setMotorPort(this.leftMotor, 1);
        setMotorPort(this.rightMotor, 2);

        this.width = width;
        this.height = height;
    }

    public synchronized double getWidth() {
        return width;
    }

    public synchronized double getHeight() {
        return height;
    }

    @Override
    public synchronized void update(double ts, Vector2 minMap, Vector2 maxMap) {
        this.ts = ts;
        super.update(ts, minMap, maxMap);

        omega = width * (rightMotor.getSpeed() - leftMotor.getSpeed());
        double speed = rightMotor.getSpeed() + leftMotor.getSpeed();
        velocity = new Vector2(speed*Math.cos(theta), speed*Math.sin(theta));

        collision(minMap, maxMap);
    }

    private void collision(Vector2 minMap, Vector2 maxMap) {
        Vector2 topRightVec = new Vector2(width/2, height/2).rotate(theta);
        Vector2 bottomRightVec = new Vector2(width/2, -height/2).rotate(theta);

        if(cornerCollides(topRightVec, minMap, maxMap) ||
               cornerCollides(bottomRightVec, minMap, maxMap)) {
            position.add(velocity.scale(-1));
        }
    }

    private boolean cornerCollides(Vector2 dir, Vector2 minMap, Vector2 maxMap) {
        double tRight = calcCollision(new Vector2(1, 0), maxMap.x, position, dir);
        double tLeft = calcCollision(new Vector2(1, 0), minMap.x, position, dir);
        double tTop = calcCollision(new Vector2(0, 1), maxMap.y, position, dir);
        double tBottom = calcCollision(new Vector2(0, 1), minMap.y, position, dir);

        return Util.between(tRight, -1, 1) || Util.between(tLeft, -1, 1) ||
               Util.between(tTop, -1, 1)   || Util.between(tBottom, -1, 1);
    }

    private double calcCollision(Vector2 normal, double d, Vector2 pos, Vector2 dir) {
        if(normal.dot(dir) == 0)
            return Double.POSITIVE_INFINITY;

        return (d - normal.dot(pos))/(normal.dot(dir));
    }

}
