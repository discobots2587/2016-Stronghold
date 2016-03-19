package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	public int tailPos=1;//1 is up & -1 is down
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon intakeMotor;
	private Solenoid intakeSol;
	private CANTalon tailMotor;
	private DigitalInput limitTail;
	public IntakeSubsystem(){
		intakeMotor = new CANTalon(HW.intakeMotor);
		intakeSol = new Solenoid(HW.intakeSolenoid);
		tailMotor = new CANTalon(HW.motorTail);
		limitTail = new DigitalInput(HW.limitSwitchBack);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setTail(double speed)
    {
    	if(0>speed)
    	{
    		while(limitTail.get()==true)
    		{
    	tailMotor.set(speed);
    		}
    	tailMotor.set(0);
    	tailPos=-1;
    	}
    	else
    	tailMotor.set(speed);
	}
    public void toggleTail(double speed)
    {
    		speed*=-tailPos;
    	if(0>speed)
    	{
    		while(limitTail.get()==true)
    		{
    	tailMotor.set(speed);
    		}
    	tailMotor.set(0);
    	tailPos=1;//to be made -1 by the command
    	}
    	else
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

