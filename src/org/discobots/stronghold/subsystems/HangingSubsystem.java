package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HangingSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
		CANTalon hookMotor;
		CANTalon winchMotor;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	hookMotor= new CANTalon(HW.motorHook);
    	winchMotor= new CANTalon(HW.motorHang);
    }
    	public void hookSpeed(double speed)
    	{
    		hookMotor.set(speed);
    	}
    	public void winchSpeed(double speed)
    	{
    		winchMotor.set(speed);
    	}
}

