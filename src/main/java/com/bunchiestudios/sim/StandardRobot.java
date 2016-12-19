package com.bunchiestudios.sim;

import com.bunchiestudios.util.Vector2;

/**
 * Created by rdelfin on 12/18/16.
 */
public class StandardRobot extends Robot {

    private Motor leftMotor;
    private Motor rightMotor;

    /**
     * Main constructor for the robot. Initializes a robot with no devices, at a starting position
     * and angle. It creates a left motor on port 1 and right motor on port 2.
     *
     * @param startPosition The initial position of the robot.
     * @param theta         Initial angle of the robot
     */
    public StandardRobot(Vector2 startPosition, double theta) {
        super(startPosition, theta);

        this.leftMotor = new Motor();
        this.rightMotor = new Motor();

        setMotorPort(this.leftMotor, 1);
        setMotorPort(this.rightMotor, 2);
    }

    @Override
    public void update() {
        super.update();


    }
}
