package com.bunchiestudios.sim;

/**
 * Created by rdelfin on 11/13/16.
 */
public class Motor {
    private double target;
    private double speed;

    /**
     * Sets the PWM value of the motor to signify forward and backwards
     * @param val A number between -1 (backwards) and 1 (forwards)
     */
    public void setValue(double val) {
        this.target = Math.max(-1, Math.min(1, val));
    }

    public double getSpeed() {
        return speed;
    }

    /**
     * Called every step to update the motor simulation and speed
     */
    public void update() {
        this.speed = this.target;
    }
}
