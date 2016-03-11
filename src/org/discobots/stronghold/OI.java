package org.discobots.stronghold;

import org.discobots.stronghold.commands.arm.MaintainArmPosCommand;
import org.discobots.stronghold.commands.arm.MoveArmCommand;
import org.discobots.stronghold.commands.drive.CycleDriveCommand;
import org.discobots.stronghold.commands.intake.SetIntakeCommand;
import org.discobots.stronghold.subsystems.ArmSubsystem;
import org.discobots.stronghold.utils.GamePad;
import org.discobots.stronghold.utils.GamePad.DPadButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private GamePad logic0 = new GamePad(0);
	private GamePad xbox = new GamePad(1); 
	
//set buttons for each joystick
	// JOYSTICK 2
	private Button b_dpadU = new DPadButton(xbox, GamePad.DPAD_Y, true);
	private Button b_dpadD = new DPadButton(xbox, GamePad.DPAD_Y, false);
	private Button b_dpadR = new DPadButton(xbox, GamePad.DPAD_X, true);
	private Button b_dpadL = new DPadButton(xbox, GamePad.DPAD_X, false);
	private Button b_bumpR = new JoystickButton(xbox, 6);
	private Button b_bumpL = new JoystickButton(xbox, 5);
	public double b_triggerR = xbox.getRawAxis(3);//Right Trigger
	public double b_triggerL = xbox.getRawAxis(2);//left trigger
	private Button b_sBack = new JoystickButton(xbox, 7);
	private Button b_sStar = new JoystickButton(xbox, 8);
	private Button b_btnA = new JoystickButton(xbox, 1);
	private Button b_btnX = new JoystickButton(xbox, 3);
	private Button b_btnB = new JoystickButton(xbox, 2);
	private Button b_btnY = new JoystickButton(xbox, 4);
	private Button b_clicR = new JoystickButton(xbox, 10);
	private Button b_clicL = new JoystickButton(xbox, 9);
	// JOYSTICK 1
	private Button b2_dpadU = new DPadButton(logic0, GamePad.DPAD_Y, true);
	private Button b2_dpadD = new DPadButton(logic0, GamePad.DPAD_Y, false);
	private Button b2_dpadR = new DPadButton(logic0, GamePad.DPAD_X, true);
	private Button b2_dpadL = new DPadButton(logic0, GamePad.DPAD_X, false);
	private Button b2_bumpR = new JoystickButton(logic0, GamePad.BTN_RB);
	private Button b2_bumpL = new JoystickButton(logic0, GamePad.BTN_LB);
	private Button b2_trigR = new JoystickButton(logic0, GamePad.BTN_RT);
	private Button b2_trigL = new JoystickButton(logic0, GamePad.BTN_LT);
	private Button b2_sBack = new JoystickButton(logic0, GamePad.BTN_BACK);
	private Button b2_sStar = new JoystickButton(logic0, GamePad.BTN_START);
	private Button b2_btnA = new JoystickButton(logic0, GamePad.BTN_A);
	private Button b2_btnX = new JoystickButton(logic0, GamePad.BTN_X);
	private Button b2_btnB = new JoystickButton(logic0, GamePad.BTN_B);
	private Button b2_btnY = new JoystickButton(logic0, GamePad.BTN_Y);
	private Button b2_clicR = new JoystickButton(logic0, GamePad.AXISBTN_R);
	private Button b2_clicL = new JoystickButton(logic0, GamePad.AXISBTN_L);
	
	public OI() {
		//JOYSTICK 2
		b2_sBack.whenPressed(new CycleDriveCommand());
		/*b2_bumpR.whileHeld(new MoveArmCommand(ArmSubsystem.armSpeed));
		b2_bumpR.whenReleased(new MaintainArmPosCommand());
		b2_bumpL.whileHeld(new MoveArmCommand(-ArmSubsystem.armSpeed));
		b2_bumpL.whenReleased(new MaintainArmPosCommand());*/
		b2_bumpR.whileHeld(new SetIntakeCommand(1.0));
		b2_bumpL.whileHeld(new SetIntakeCommand(-1.0));
		b_bumpR.whenReleased(new SetIntakeCommand(0));
		b_bumpL.whenReleased(new SetIntakeCommand(0));
		
		
		//JOYSTICK 1
		b_bumpR.whileHeld(new SetIntakeCommand(1));
		b_bumpL.whileHeld(new SetIntakeCommand(-1));
		b_bumpR.whenReleased(new SetIntakeCommand(0));
		b_bumpL.whenReleased(new SetIntakeCommand(0));
		
		b_sBack.whenPressed(new CycleDriveCommand());
/*		b_bumpR.whileHeld(new MoveArmCommand(ArmSubsystem.armSpeed));
		b_bumpR.whenReleased(new MaintainArmPosCommand());
		b_bumpL.whileHeld(new MoveArmCommand(-ArmSubsystem.armSpeed));
		b_bumpL.whenReleased(new MaintainArmPosCommand());*/
	}
	public double getRawAnalogStickALX() {
		if(logic0.getRawAxis(0)>0.1||logic0.getRawAxis(0)<=-0.1)
			return logic0.getRawAxis(0);
		else
		{
			return (xbox.getRawAxis(0));// left stick y-axis	}
		}
	}
	

	
	public double getRawAnalogStickALY() {
		if(logic0.getRawAxis(1)>0.1||logic0.getRawAxis(1)<=-0.1)
		return -logic0.getRawAxis(1);
		else
		return (-xbox.getRawAxis(1));// left stick y-axis

	}

	public double getRawAnalogStickARX() {
		if(logic0.getRawAxis(4)>=0.1||logic0.getRawAxis(4)<=-0.1)
		return logic0.getRawAxis(4);
		else
		return (xbox.getRawAxis(4));// left stick x-axis
	}

	public static enum Hand { 
        LEFT, RIGHT 
} 
	
	public void setRumble(Hand hand, double intensity) { //set for single side of controller
		  	final float amount = new Float(intensity); 
		  	        
			   if (hand == Hand.LEFT) { 
		  	            xbox.setRumble(RumbleType.kLeftRumble, amount); 
		 	        } 
			   if (hand==Hand.RIGHT)
		 	        { 
		 	             xbox.setRumble(RumbleType.kRightRumble, amount); 
		  	        } 
			     } 
	     public void setRumble(double intensity) { //set rumble for both hands
		         final float amount = new Float(intensity); 
		          
		         xbox.setRumble(RumbleType.kLeftRumble, amount); 
		         xbox.setRumble(RumbleType.kRightRumble, amount); 
		     } 


	public double getRawAnalogStickARY() {
		if(logic0.getRawAxis(5)>=0.1||logic0.getRawAxis(5)<=-0.1)
		return logic0.getRawAxis(5);
		else
		return (xbox.getRawAxis(5));
	}

	public double getRawAnalogStickBLX() {
		return (xbox.getRawAxis(0));
	}

	public double getRawAnalogStickBLY() {
		return (-xbox.getRawAxis(1));// left stick y-axis

	}

	public double getRawAnalogStickBRX() {
		return (xbox.getRawAxis(4));// left stick x-axis

	}

	public double getRawAnalogStickBRY() {
		return (xbox.getRawAxis(5));// left stick x-axis
	}
		
	
	public double getLogicLT()
	{
		return(logic0.getRawAxis(2));
	}
	
	public double getLogicRT()
		{
			return(logic0.getRawAxis(3));
		}
		
	public double getRT(){
		return (xbox.getRawAxis(3));
	}
	public double getLT(){
		return (xbox.getRawAxis(2));
	} 
}
