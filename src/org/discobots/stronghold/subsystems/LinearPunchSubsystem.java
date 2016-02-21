package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LinearPunchSubsystem extends Subsystem {
    CANTalon punch; // = new CANTalon(HW.motorPunch);
    Potentiometer LPSensor;
    
    public LinearPunchSubsystem(){
    punch = new CANTalon(HW.motorPunch);
    LPSensor = new AnalogPotentiometer(0, 360, 30);	
    }
   //double degrees = pot.get()
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getLPSensorData(){
    return LPSensor.get();	
    }
    
    
    public Boolean isLoaded()
    {
    	return false;
    	
    }
    
    public void pull(double speed) {
    	punch.set(speed);
    	
    	
    }
}

