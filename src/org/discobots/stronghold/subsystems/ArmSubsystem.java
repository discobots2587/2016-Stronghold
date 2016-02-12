package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;
import org.discobots.stronghold.commands.arm.MaintainArmPosCommand;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public AnalogInput potentiometer;
	public Talon armMotor;
	public final double kP = .2; //P constant
	public static final double armSpeed = .5;
	
	
	public ArmSubsystem()
	{
		potentiometer = new AnalogInput(HW.potentiometer);
		armMotor = new Talon(HW.armMotor);
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MaintainArmPosCommand());
    }
}

