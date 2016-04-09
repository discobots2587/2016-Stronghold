package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;
import org.discobots.stronghold.Robot;
import org.discobots.stronghold.commands.arm.BrakeCommand;
import org.discobots.stronghold.commands.arm.MaintainArmPosCommand;
import org.discobots.stronghold.utils.LTRTXBOX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public AnalogInput potentiometer;
	//public AnalogInput testPot;
	public CANTalon armMotor;
	public Solenoid discSol;
	public final double kP = .5; //P constant
	public static final double armSpeed = .5;
	public DigitalInput frontLimit;
    public DigitalInput backLimit;//limit switch
	public String[] SensorToggleS={"ALL SENSORS OFF","BOTTOM SWITCH OFF","ALL SENSORS ON"};
	//public boolean sensorToggle=true;
	public int sensorToggle=1;
	public double upperArmLim = 2.399;
	public double lowerArmLim = .610;
	public final double kSpeed = .75;


	public ArmSubsystem()
	{
		frontLimit=new DigitalInput(0);
//		backLimit = new DigitalInput(1);
		potentiometer = new AnalogInput(HW.potentiometer);
		//testPot = new AnalogInput(HW.pot1);
		armMotor = new CANTalon(HW.armMotor);
		discSol = new Solenoid(HW.brakeSolenoid);
	}
	
	public void setSpeed(double speed)
	{
		/*if (speed==0)
		{
			armMotor.set(0);
			setBrake(true);
		}
		if(sensorToggle)
		{
			if(speed<0 && potentiometer.getAverageVoltage()<upperArmLim){ //Checks to see if upperLim has been reached
				setBrake(false);
				armMotor.set(speed*kSpeed);
			} else if(speed>0 && potentiometer.getAverageVoltage()>lowerArmLim){ //Checks to see if lowerLim has been reached
				setBrake(false);
				armMotor.set(speed*kSpeed);
			} else
				armMotor.set(0);
				setBrake(true);
				
		}
		else
		{
			setBrake(false);
			armMotor.set(speed*kSpeed);
		}*/
		
		if (-.15<speed && speed<.15)
		{
			armMotor.set(0);
			setBrake(true);
		}
		else if(potentiometer.getAverageVoltage()<=upperArmLim&&speed<0)//upper potentiometer limit
		{
			if(sensorToggle==2||sensorToggle==1)
			{
				speed=0;
				armMotor.set(speed*kSpeed);
				setBrake(true);
			}
			else
			{
				setBrake(false);
				armMotor.set(speed*Robot.armSub.kSpeed);
			}
		}

		else if(!frontLimit.get()&&speed>0)//limit switch bottom limit
		{
			if(sensorToggle==1)
			{
				speed=0;
				armMotor.set(speed*kSpeed);
				setBrake(true);
			}
		else
			{
			setBrake(false);
			armMotor.set(speed*kSpeed);
			}
		}
		
		//SPEEED STEPS----------SPEEED STEPS----------SPEEED STEPS----------SPEEED STEPS----------SPEEED STEPS----------SPEEED STEPS----------SPEEED STEPS----------
		else if(3.8<potentiometer.getAverageVoltage()&&potentiometer.getAverageVoltage()<4.5&&speed<0)//upper speed limit 1
		{
			if(sensorToggle==2||sensorToggle==1)
			{
			setBrake(false);
			speed*=-(3.8-potentiometer.getAverageVoltage());
			armMotor.set(speed*kSpeed);
			}
			else
			{
				setBrake(false);
				armMotor.set(speed*kSpeed);
			}
		}
		else
		{
			setBrake(false);
			armMotor.set(speed*kSpeed);	
		}

		/*		if(backLimit.get()&&speed<0)
		{
			speed=0;
			armMotor.set(speed);
		}
*/	}

   public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new LTRTXBOX());
    //	setDefaultCommand(new MaintainArmPosCommand());
   }
   
   public void setBrake(boolean x){
	   discSol.set(x);
   }
   
   public boolean getBrake(){
	   return discSol.get();
   }

}
