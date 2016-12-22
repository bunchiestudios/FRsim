package com.bunchiestudios.wpi;

import com.bunchiestudios.control.Control;

/**
 * Created by franspaco on 7/11/16.
 */
public class AnalogInput {
    int port;
    public AnalogInput(int port){
        this.port = port;
        Control.analogs.putIfAbsent(port, this);
    }

    void free(){

    }

    double getAverageVoltage(){
        
    }
}
