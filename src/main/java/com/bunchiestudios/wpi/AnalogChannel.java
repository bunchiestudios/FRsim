package com.bunchiestudios.wpi;

import com.bunchiestudios.control.Control;

/**
 * Created by franspaco on 7/11/16.
 */
public class AnalogChannel {
    int port;
    public AnalogChannel(int port){
        this.port = port;
        Control.analogs.putIfAbsent(port, this);
    }


}
