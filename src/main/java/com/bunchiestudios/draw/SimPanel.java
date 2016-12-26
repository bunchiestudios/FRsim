package com.bunchiestudios.draw;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by rdelfin on 12/21/16.
 */
public class SimPanel extends JPanel {
        private boolean running;

    public SimPanel() {
        super();
        setBackground(Color.WHITE);

        running = true;
    }

    public void stop() {
        running = false;
    }

    public void paintComponent(Graphics g)  // draw graphics in the panel
    {
        int width = getWidth();
        int height = getHeight();

        super.paintComponent(g);
    }
}
