package com.bunchiestudios.sim;

import com.bunchiestudios.util.Vector2;

/**
 * This class represents the simulated robot. It manages the robot's location in the world, sensors, motors, as well
 * as collission and interaction with world objects (such as the map and game elements)
 */
public class Robot {
    private static Robot _instance = null;

    public static synchronized Robot getInstance() {
        return _instance;
    }

    public static void initialize(Vector2 startPosition, double theta) {
        _instance = new Robot(startPosition, theta);
    }

    private Vector2 position, velocity, acceleration;
    private double theta, omega, alpha;

    /**
     * Main constructor for the robot. Initializes a robot with no devices, at a starting position and angle
     * @param startPosition The initial position of the robot.
     * @param theta Initial angle of the robot
     */
    public Robot(Vector2 startPosition, double theta) {
        this.position = startPosition;
        this.velocity = new Vector2();
        this.acceleration = new Vector2();
        this.theta = theta;
        this.omega = 0;
        this.alpha = 0;
    }

    /**
     * Allows you to setup an analog port device, such as an Ultrasonic distance sensor
     * @param device The object representing the device
     * @param port Port number to be attached to on the roboRIO
     */
    public synchronized void setAnalogPort(AnalogDevice device, int port) {

    }

    /**
     * Allows you to setup a motor to a given port device, all simulated to work as talon controllers
     * @param motor The motor object
     * @param port  Port number the motor is connected to on the roboRIO
     */
    public synchronized void setMotorPort(Motor motor, int port) {

    }

    /**
     * Used to set the motor PWM value of the motor, that gets passed onto the motor
     * @param port  Port number of the motor
     * @param value Value of the PWM signal, from -1 to 1
     */
    public synchronized void setPWM(int port, double value) {

    }

    /**
     * Returns the voltage reading for the analog channel, reading a 12-bit number from 0-4096. Read
     * http://wpilib.screenstepslive.com/s/3120/m/7912/l/85775-analog-inputs for more details
     * @param port Port number of the analog channel
     * @return The voltage reading of the port
     */
    public synchronized double readAnalog(int port) {
        return 0;
    }

    /**
     * Updates the state of the robot and the simulation. Should be called periodically
     */
    public synchronized void update() {

    }
}
