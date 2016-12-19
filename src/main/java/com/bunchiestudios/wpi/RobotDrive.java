package com.bunchiestudios.wpi;

/**
 * Created by franspaco on 7/11/16.
 */
public class RobotDrive {
    Talon tR;
    Talon tL;

    public RobotDrive(int leftMotorChannel, int rightMotorChannel){
        tL = new Talon(leftMotorChannel);
        tR = new Talon(rightMotorChannel);
    }

    public void arcadeDrive(double moveValue, double rotateValue){

    }


}
