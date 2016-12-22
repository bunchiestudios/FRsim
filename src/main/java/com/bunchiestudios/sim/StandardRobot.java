package com.bunchiestudios.sim;

import com.bunchiestudios.util.Util;
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

    /**
     * Getter for the robot width
     * @return The robot width, in meters
     */
    public synchronized double getWidth() {
        return width;
    }

    /**
     * Getter for the robot height
     * @return The robot height, in meters
     */
    public synchronized double getHeight() {
        return height;
    }

    /**
     * Update routine for the robot. It calculates the simualtion, and sets the linear and
     * angular velocities according to the speed set by the motors.
     * @param ts Timestep size in seconds
     * @param minMap Lower left corner of the map
     * @param maxMap Upper right corner of the map
     */
    @Override
    public synchronized void update(double ts, Vector2 minMap, Vector2 maxMap) {
        omega = width * (rightMotor.getSpeed() - leftMotor.getSpeed());
        double speed = rightMotor.getSpeed() + leftMotor.getSpeed();
        velocity = new Vector2(speed*Math.cos(theta), speed*Math.sin(theta));

        collision(minMap, maxMap, ts);

        super.update(ts, minMap, maxMap);
    }

    /**
     * Manages the collission logic. If collision is detected on walls, it will move back
     * by velocity*ts.
     * @param minMap The lower-left corner of the map
     * @param maxMap The upper-right corner of the map
     * @param ts Timestep size, in seconds
     */
    private void collision(Vector2 minMap, Vector2 maxMap, double ts) {
        Vector2 topRightVec = new Vector2(width/2, height/2).rotate(theta);
        Vector2 bottomRightVec = new Vector2(width/2, -height/2).rotate(theta);

        if(cornerCollides(topRightVec, minMap, maxMap) ||
               cornerCollides(bottomRightVec, minMap, maxMap)) {
            position.add(velocity.scale(-ts)); // Backtrack in whatever direction got you here.
        }
    }

    /**
     * Checks if a given pair of opposite corners of the robot collide with the walls.
     * @param dir Specifies the distance from the corner to the center of the robot
     * @param minMap Lower-left corner of the map
     * @param maxMap Upper-right corner of the map
     * @return True if there is a collision. False otherwise
     */
    private boolean cornerCollides(Vector2 dir, Vector2 minMap, Vector2 maxMap) {
        double tRight = calcCollision(new Vector2(1, 0), maxMap.x, position, dir);
        double tLeft = calcCollision(new Vector2(1, 0), minMap.x, position, dir);
        double tTop = calcCollision(new Vector2(0, 1), maxMap.y, position, dir);
        double tBottom = calcCollision(new Vector2(0, 1), minMap.y, position, dir);

        return Util.between(tRight, -1, 1) || Util.between(tLeft, -1, 1) ||
               Util.between(tTop, -1, 1)   || Util.between(tBottom, -1, 1);
    }

    /**
     * Calculates the intersection of a line and a ray, the second specified in the parametric
     * form `pos + t*dir`, where t is the parameter for the ray. The line is the set of all
     * vectors r that satisfy dot(normal, r) = d.
     * @param normal Normal of the line to collide with
     * @param d Right hand side of the line equation
     * @param pos The starting position of the parametric ray in `pos + t*dir`
     * @param dir The direction of the parametric ray in `pos + t*dir`
     * @return Double representing the parameter `t` at which the intersection happens. Returns
     *         `Double.POSITIVE_INFINITY` if the lines do not collide.
     */
    private double calcCollision(Vector2 normal, double d, Vector2 pos, Vector2 dir) {
        if(normal.dot(dir) == 0)
            return Double.POSITIVE_INFINITY;

        return (d - normal.dot(pos))/(normal.dot(dir));
    }

}
