package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ServoSubsystem extends Subsystem {
    Servo silver; // = new CANTalon(HW.motorPunch);
    
    public ServoSubsystem(){
    silver = new Servo(HW.servo);
    }
   //double degrees = pot.get()
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
        
    

    
    public void run() {
    //	if(!isReady)
    //	punch.set(speed);
    	
    	silver.set(1);
    	
    	//if(isReady)
    	//punch.set(0.0);
    }
    
  /*  public void stop(Boolean isFinished)
    {
    	if(isFinished)
    	{pull(0.0);}
    	
    }*/
    
}


