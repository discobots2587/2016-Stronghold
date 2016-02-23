package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
	
	public CANTalon shooterMotor;

	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ShooterSubsystem()
	{
		shooterMotor = new CANTalon(HW.shooter);
		
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }


	public void SetShooter(double speed) {
		shooterMotor.set(speed);
	}

}