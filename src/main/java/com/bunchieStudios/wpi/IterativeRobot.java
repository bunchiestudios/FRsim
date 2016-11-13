package com.bunchieStudios.wpi;

/**
 * Created by franspaco on 7/11/16.
 */
public abstract class IterativeRobot {
    public abstract void robotInit();
    public abstract void autonomousInit();
    public abstract void autonomousPeriodic();
    public abstract void teleopInit();
    public abstract void teleopPeriodic();
}
