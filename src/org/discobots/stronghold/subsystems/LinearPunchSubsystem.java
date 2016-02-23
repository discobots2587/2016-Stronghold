package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;

import edu.wpi.first.wpilibj.AnalogInput;
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
    AnalogInput LPSensor;
    
    public LinearPunchSubsystem(){
    punch = new CANTalon(HW.motorPunch);
    LPSensor = new AnalogInput(HW.LPSensor);	
    }
   //double degrees = pot.get()
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getLPSensorData(){
    return LPSensor.getValue();	
    }
    
    
    public Boolean isReady()
    {
    	return getLPSensorData() < 100;
    	
    }
    
    public void pull(double speed, Boolean isReady) {
    	if(!isReady)
    	punch.set(speed);
    	
    	if(isReady)
    	punch.set(0.0);
    }
    
  /*  public void stop(Boolean isFinished)
    {
    	if(isFinished)
    	{pull(0.0);}
    	
    }*/
    
}


