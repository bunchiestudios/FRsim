package com.bunchiestudios.draw;

import org.junit.Test;

/**
 * Created by rdelfin on 12/21/16.
 */
public class WindowTest {

    @Test
    public void windowTest() throws InterruptedException {
        Thread t = new Draw();
        t.start();
        t.join();
    }
}
