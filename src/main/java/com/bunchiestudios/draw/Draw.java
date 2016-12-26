package com.bunchiestudios.draw;


import javax.swing.*;

/**
 * Created by rdelfin on 12/21/16.
 */
public class Draw extends Thread {
    private boolean running;

    public Draw() {
        running = true;
    }

    public void stopScreen() {
        running = false;
    }

    @Override
    public void run() {
        SimPanel panel = new SimPanel();                            // window for drawing
        JFrame application = new JFrame();                            // the program itself

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
        // when it is closed
        application.add(panel);


        application.setSize(500, 400);         // window is 500 pixels wide, 400 high
        application.setVisible(true);

        try {
            while (running) {
                application.repaint();
                Thread.sleep(10);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
