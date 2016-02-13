package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Talon intakeMotor;
	
	public IntakeSubsystem(){
		intakeMotor = new Talon(HW.intakeMotor);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setIntakeSpeed(double speed){
    	intakeMotor.set(speed);
    }
}

