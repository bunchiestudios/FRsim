package com.bunchieStudios.control;

import com.bunchieStudios.RobotCode.MyRobot;
import com.bunchieStudios.wpi.*;
//import net.java.games.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by franspaco on 12/17/2016.
 */
public class Control extends Thread {

    MyRobot code;
    int routine;

    public static Map<Integer, Joystick> joysticks;

    public Control(){
        joysticks = new HashMap<Integer, Joystick>();
        //routine = JOptionPane.showInputDialog(null, "");
    }

    @Override
    public void run(){
        //code.autonomousInit();
    }
}
