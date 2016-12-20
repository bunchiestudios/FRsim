package com.bunchiestudios.control;

import com.bunchiestudios.robotcode.MyRobot;
import com.bunchiestudios.wpi.*;


import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by franspaco on 12/17/2016.
 */
public class Control extends Thread {

    MyRobot code;
    int routine = -1;

    public static Map<Integer, Joystick> joysticks;
    public static Map<Integer, Talon> talons;
    public static Map<Integer, AnalogInput> analogs;

    public Control(){
        joysticks = new HashMap<Integer, Joystick>();
        talons    = new HashMap<Integer, Talon>();
        analogs   = new HashMap<Integer, AnalogInput>();

        String[] options = {"Autonomous", "Teleop", "Full routine" };
        routine = JOptionPane.showOptionDialog(null, "Select an option:", "Routine", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

        if (routine == -1){
            System.exit(0);
        }
    }

    @Override
    public void run(){
        //code.autonomousInit();
        //Joystick j1 = new Joystick(1);

    }
}
