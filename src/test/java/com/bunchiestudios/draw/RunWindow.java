package com.bunchiestudios.draw;

import com.bunchiestudios.sim.Simulator;
import com.bunchiestudios.util.Vector2;
import org.junit.Test;

/**
 * Created by rdelfin on 12/21/16.
 */
public class RunWindow {

    @Test
    public void windowTest() throws InterruptedException {
        Thread sim = new Simulator(new Vector2(2, 2), 0);
        Thread draw = new Draw();
        sim.start();
        draw.start();
        draw.join();
        sim.join();
    }
}
