package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;
import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
	
	public Solenoid shooter1;
	public Solenoid shooter2;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ShooterSubsystem()
	{
		shooter1 = new Solenoid(HW.shooter1);
		shooter2 = new Solenoid(HW.shooter2);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}