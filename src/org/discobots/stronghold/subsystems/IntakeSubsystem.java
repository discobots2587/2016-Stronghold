package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon intakeMotor;
	private Solenoid intakeSol;
	private CANTalon tailMotor;
	public IntakeSubsystem(){
		intakeMotor = new CANTalon(HW.intakeMotor);
		intakeSol = new Solenoid(HW.intakeSolenoid);
		tailMotor = new CANTalon(HW.motorTail);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setTail(double speed)
    {
    	tailMotor.set(speed);
    }
    public void setIntakeSpeed(double speed){
    	intakeMotor.set(speed);
    }
    
    public void setIntake(boolean set){
    	intakeSol.set(set);
    }
    
    public boolean getIntake(){
    	return intakeSol.get();
    }
}

