package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class WenchSubsystem extends Subsystem {
    CANTalon wench; // = new CANTalon(HW.motorPunch);
    
    public WenchSubsystem(){
    wench = new CANTalon(HW.motorWench);
    	
    }
   
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void pull(double speed) {
    	wench.set(speed);
    	
    	
    }
}

