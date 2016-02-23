package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;
import org.discobots.stronghold.commands.arm.MaintainArmPosCommand;
import org.discobots.stronghold.utils.LTRTXBOX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
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
	public CANTalon armMotor;
	public Solenoid discSol;
	public final double kP = .5; //P constant
	public static final double armSpeed = .5;

	

	public ArmSubsystem()
	{
	//	potentiometer = new AnalogInput(HW.potentiometer);
		armMotor = new CANTalon(HW.armMotor);
		discSol = new Solenoid(HW.brakeSolenoid);
	}
		public void setSpeed(double speed)
		{
			armMotor.set(speed);	
		}

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
