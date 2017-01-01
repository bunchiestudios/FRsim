package com.bunchiestudios.wpi;

import com.bunchiestudios.control.Control;

/**
 * Created by franspaco on 7/11/16.
 */
public class AnalogInput {

    private int channel;

    private double voltage;

    public AnalogInput(final int channel){
        this.channel = channel;
        Control.analogs.putIfAbsent(channel, this);
        voltage = 0;
    }

    private int voltToValue(){
        return (int)((5.0/4096.0) * voltage);
    }

    /**
     * You should never, ever use this. Never.
     *
     * @return Pain and destruction.
     */
    public void potatoes(double bananas){
       voltage = bananas;
    }

    /**
     * Channel destructor.
     */
    public void free(){
        Control.analogs.remove(channel);
    }

    /**
     * Get a sample straight from this channel. The sample is a 12-bit value
     * representing the 0V to 5V range of the A/D converter. The units are in A/D
     * converter codes. Use GetVoltage() to get the analog value in calibrated
     * units.
     *
     * @return A sample straight from this channel.
     */
    public int getValue() {
        return voltToValue();
    }

    /**
     * Get a sample from the output of the oversample and average engine for this
     * channel. The sample is 12-bit + the bits configured in SetOversampleBits().
     * The value configured in setAverageBits() will cause this value to be
     * averaged 2^bits number of samples. This is not a sliding window. The sample
     * will not change until 2^(OversampleBits + AverageBits) samples have been
     * acquired from this channel. Use getAverageVoltage() to get the analog value
     * in calibrated units.
     *
     * @return A sample from the oversample and average engine for this channel.
     */
    public int getAverageValue() {
        return voltToValue();
    }

    /**
     * Get a scaled sample straight from this channel. The value is scaled to
     * units of Volts using the calibrated scaling data from getLSBWeight() and
     * getOffset().
     *
     * @return A scaled sample straight from this channel.
     */
    public double getVoltage() {
        return voltage;
    }

    /**
     * Get a scaled sample from the output of the oversample and average engine
     * for this channel. The value is scaled to units of Volts using the
     * calibrated scaling data from getLSBWeight() and getOffset(). Using
     * oversampling will cause this value to be higher resolution, but it will
     * update more slowly. Using averaging will cause this value to be more
     * stable, but it will update more slowly.
     *
     * @return A scaled sample from the output of the oversample and average
     *         engine for this channel.
     */
    public double getAverageVoltage() {
        return voltage;
    }

}
