package com.bunchiestudios.draw;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rdelfin on 12/21/16.
 */
public class SimPanel extends JPanel {
    public SimPanel() {
        super();
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)  // draw graphics in the panel
    {
        int width = getWidth();             // width of window in pixels
        int height = getHeight();           // height of window in pixels

        super.paintComponent(g);            // call superclass to make panel display correctly

        // Drawing code goes here
    }
}
