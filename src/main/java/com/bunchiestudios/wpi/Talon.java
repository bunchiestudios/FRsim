package com.bunchiestudios.wpi;

import com.bunchiestudios.control.Control;

/**
 * Created by franspaco on 12/18/2016.
 */
public class Talon {
    int port;
    double value;

    public Talon(int port){
        this.port = port;
        value = 0;
        Control.talons.putIfAbsent(port, this);
    }

    double get(){
        return value;
    }

    void set(){
        
    }

}
