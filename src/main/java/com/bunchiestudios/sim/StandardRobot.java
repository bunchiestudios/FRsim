package com.bunchiestudios.sim;

import com.bunchiestudios.util.Vector2;

/**
 * Created by rdelfin on 12/18/16.
 */
public class StandardRobot extends Robot {

    private Motor leftMotor;
    private Motor rightMotor;

    private double width, height;

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

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void update(double ts) {
        super.update(ts);

        omega = width * (rightMotor.getSpeed() - leftMotor.getSpeed());
        double speed = rightMotor.getSpeed() + leftMotor.getSpeed();
        velocity = new Vector2(speed*Math.cos(theta), speed*Math.sin(theta));
    }
}
