package com.bunchiestudios.sim;

import com.bunchiestudios.util.Vector2;

/**
 * Created by rdelfin on 12/17/16.
 */
public class Simulator extends Thread {
    private boolean running;

    public void stopSimulator() {
        running = false;
    }

    Simulator(Vector2 robotStartPos, double robotStartTheta) {
        Robot.initialize(robotStartPos, robotStartTheta);
        running = true;
    }

    @Override
    public void run() {
        while(running) {
            long start = System.currentTimeMillis();

            simulate();

            long end = System.currentTimeMillis();

            try {
                Thread.sleep(Math.max(16 - (end - start), 0));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void simulate() {

    }
}
