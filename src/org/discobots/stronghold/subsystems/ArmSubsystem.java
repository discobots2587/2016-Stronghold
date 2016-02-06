package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class ArmSubsystem extends PIDSubsystem {
private AnalogInput potentometer = new AnalogInput(HW.potentiometer);//new potentiometer
private static final double kP = .25;
private static final double kI = 0,kD = 0;
    // Initialize your subsystem here
    public ArmSubsystem() {
    	super(kP,kI,kD);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
