package com.bunchiestudios.sim;

/**
 * Represents an analog device
 */
public interface AnalogDevice {
    /**
     * Implement this method to obtain the Voltage measurement for a given analog device
     * @return A voltage value, usually fro -10V to 10V
     */
    double getVoltage();

    /**
     * Called every timestamp to re-compute simulated voltage.
     */
    void update();
}
