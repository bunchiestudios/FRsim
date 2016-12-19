package com.bunchiestudios.wpi;

import com.bunchiestudios.control.Control;

/**
 * Created by franspaco on 12/18/2016.
 */
public class Joystick {
    int port;

    public Joystick(int port) {
        this.port = port;
        Control.joysticks.put(port, this);
    }

    public double getX(){
        return 0;
    }

    public double getY(){
        return 0;
    }

    public boolean getRawButton(int button){
        return false;
    }
}
