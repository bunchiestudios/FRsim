package com.bunchieStudios.Sim;

import com.bunchieStudios.Util.Vector2;

/**
 * Created by rdelfin on 12/17/16.
 */
public class Simulator extends Thread {
    Simulator(Vector2 robotStartPos, double robotStartTheta) {
        Robot.initialize(robotStartPos, robotStartTheta);
    }

    @Override
    public void run() {

    }
}
