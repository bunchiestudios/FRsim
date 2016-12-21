package com.bunchiestudios.sim;

import com.bunchiestudios.util.Vector2;

/**
 * Created by rdelfin on 12/17/16.
 */
public class Simulator extends Thread {
    private double ts;
    private boolean running;

    public void stopSimulator() {
        running = false;
    }

    public Simulator(Vector2 robotStartPos, double robotStartTheta) {
        Robot.initialize(new StandardRobot(robotStartPos, robotStartTheta, 0.6, 0.9));
        this.running = true;
        this.ts = 0.016;
    }

    @Override
    public void run() {
        while(running) {
            long start = System.currentTimeMillis();

            simulate();

            long end = System.currentTimeMillis();

            try {
                Thread.sleep(Math.max((long)(ts*1000) - (end - start), 0));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void simulate() {
        Robot.getInstance().update(ts);
    }
}
