package com.bunchiestudios.wpi;

/**
 * Created by franspaco on 7/11/16.
 */
public class RobotDrive {
    Talon tR;
    Talon tL;

    public static final double kDefaultMaxOutput = 1.0;
    public static final double kDefaultSensitivity = 0.5;

    protected double m_maxOutput;
    protected double m_sensitivity;

    public RobotDrive(final int leftMotorChannel, final int rightMotorChannel){
        tL = new Talon(leftMotorChannel);
        tR = new Talon(rightMotorChannel);

        m_sensitivity = kDefaultSensitivity;
        m_maxOutput = kDefaultMaxOutput;
    }

    /**
     * Drive the motors at "outputMagnitude" and "curve".
     * Both outputMagnitude and curve are -1.0 to +1.0 values, where 0.0
     * represents stopped and not turning. {@literal curve < 0 will turn left and curve > 0}
     * will turn right.
     *
     * The algorithm for steering provides a constant turn radius for any normal
     * speed range, both forward and backward. Increasing m_sensitivity causes
     * sharper turns for fixed values of curve.
     *
     * This function will most likely be used in an autonomous routine.
     *
     * @param outputMagnitude The speed setting for the outside wheel in a turn,
     *        forward or backwards, +1 to -1.
     * @param curve The rate of turn, constant for different forward speeds. Set
     *        {@literal curve < 0 for left turn or curve > 0 for right turn.}
     * Set curve = e^(-r/w) to get a turn radius r for wheelbase w of your robot.
     * Conversely, turn radius r = -ln(curve)*w for a given value of curve and
     * wheelbase w.
     */
    public void drive(double outputMagnitude, double curve) {
        double leftOutput, rightOutput;

        if (curve < 0) {
            double value = Math.log(-curve);
            double ratio = (value - m_sensitivity) / (value + m_sensitivity);
            if (ratio == 0) {
                ratio = .0000000001;
            }
            leftOutput = outputMagnitude / ratio;
            rightOutput = outputMagnitude;
        } else if (curve > 0) {
            double value = Math.log(curve);
            double ratio = (value - m_sensitivity) / (value + m_sensitivity);
            if (ratio == 0) {
                ratio = .0000000001;
            }
            leftOutput = outputMagnitude;
            rightOutput = outputMagnitude / ratio;
        } else {
            leftOutput = outputMagnitude;
            rightOutput = outputMagnitude;
        }
        setLeftRightMotorOutputs(leftOutput, rightOutput);
    }

    /**
     * Provide tank steering using the stored robot configuration. This function
     * lets you directly provide joystick values from any source.
     *$
     * @param leftValue The value of the left stick.
     * @param rightValue The value of the right stick.
     * @param squaredInputs Setting this parameter to true decreases the
     *        sensitivity at lower speeds
     */
    public void tankDrive(double leftValue, double rightValue, boolean squaredInputs) {

        // square the inputs (while preserving the sign) to increase fine control
        // while permitting full power
        leftValue = limit(leftValue);
        rightValue = limit(rightValue);
        if (squaredInputs) {
            if (leftValue >= 0.0) {
                leftValue = (leftValue * leftValue);
            } else {
                leftValue = -(leftValue * leftValue);
            }
            if (rightValue >= 0.0) {
                rightValue = (rightValue * rightValue);
            } else {
                rightValue = -(rightValue * rightValue);
            }
        }
        setLeftRightMotorOutputs(leftValue, rightValue);
    }

    /**
     * Provide tank steering using the stored robot configuration. This function
     * lets you directly provide joystick values from any source.
     *$
     * @param leftValue The value of the left stick.
     * @param rightValue The value of the right stick.
     */
    public void tankDrive(double leftValue, double rightValue) {
        tankDrive(leftValue, rightValue, true);
    }

    /**
     * Arcade drive implements single stick driving. This function lets you
     * directly provide joystick values from any source.
     *$
     * @param moveValue The value to use for forwards/backwards
     * @param rotateValue The value to use for the rotate right/left
     * @param squaredInputs If set, decreases the sensitivity at low speeds
     */
    public void arcadeDrive(double moveValue, double rotateValue, boolean squaredInputs) {
        // local variables to hold the computed PWM values for the motors

        double leftMotorSpeed;
        double rightMotorSpeed;

        moveValue = limit(moveValue);
        rotateValue = limit(rotateValue);

        if (squaredInputs) {
            // square the inputs (while preserving the sign) to increase fine control
            // while permitting full power
            if (moveValue >= 0.0) {
                moveValue = (moveValue * moveValue);
            } else {
                moveValue = -(moveValue * moveValue);
            }
            if (rotateValue >= 0.0) {
                rotateValue = (rotateValue * rotateValue);
            } else {
                rotateValue = -(rotateValue * rotateValue);
            }
        }

        if (moveValue > 0.0) {
            if (rotateValue > 0.0) {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = Math.max(moveValue, rotateValue);
            } else {
                leftMotorSpeed = Math.max(moveValue, -rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
        } else {
            if (rotateValue > 0.0) {
                leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            } else {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
            }
        }

        setLeftRightMotorOutputs(leftMotorSpeed, rightMotorSpeed);
    }

    /**
     * Arcade drive implements single stick driving. This function lets you
     * directly provide joystick values from any source.
     *$
     * @param moveValue The value to use for fowards/backwards
     * @param rotateValue The value to use for the rotate right/left
     */
    public void arcadeDrive(double moveValue, double rotateValue) {
        this.arcadeDrive(moveValue, rotateValue, true);
    }

    /**
     * Set the speed of the right and left motors. This is used once an
     * appropriate drive setup function is called such as twoWheelDrive(). The
     * motors are set to "leftSpeed" and "rightSpeed" and includes flipping the
     * direction of one side for opposing motors.
     *$
     * @param leftOutput The speed to send to the left side of the robot.
     * @param rightOutput The speed to send to the right side of the robot.
     */
    public void setLeftRightMotorOutputs(double leftOutput, double rightOutput) {
        if (tL == null || tR == null) {
            throw new NullPointerException("Null motor provided");
        }

        tL.set(limit(leftOutput) * m_maxOutput);

        tR.set(-limit(rightOutput) * m_maxOutput);
    }

    /**
     * Limit motor values to the -1.0 to +1.0 range.
     */
    protected static double limit(double num) {
        if (num > 1.0) {
            return 1.0;
        }
        if (num < -1.0) {
            return -1.0;
        }
        return num;
    }
}
