package org.discobots.steamworks;

import org.discobots.steamworks.commands.drive.CycleDriveCommand;
import org.discobots.steamworks.utils.GamePad;
import org.discobots.steamworks.utils.GamePad.DPadButton;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
		private GamePad gp1 = new GamePad(0);
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
		private Button b2_dpadU = new DPadButton(gp1, GamePad.DPAD_Y, true);
		private Button b2_dpadD = new DPadButton(gp1, GamePad.DPAD_Y, false);
		private Button b2_dpadR = new DPadButton(gp1, GamePad.DPAD_X, true);
		private Button b2_dpadL = new DPadButton(gp1, GamePad.DPAD_X, false);
		private Button b2_bumpR = new JoystickButton(gp1, GamePad.BTN_RB);
		private Button b2_bumpL = new JoystickButton(gp1, GamePad.BTN_LB);
		private Button b2_trigR = new JoystickButton(gp1, GamePad.BTN_RT);
		private Button b2_trigL = new JoystickButton(gp1, GamePad.BTN_LT);
		private Button b2_sBack = new JoystickButton(gp1, GamePad.BTN_BACK);
		private Button b2_sStar = new JoystickButton(gp1, GamePad.BTN_START);
		private Button b2_btnA = new JoystickButton(gp1, GamePad.BTN_A);
		private Button b2_btnX = new JoystickButton(gp1, GamePad.BTN_X);
		private Button b2_btnB = new JoystickButton(gp1, GamePad.BTN_B);
		private Button b2_btnY = new JoystickButton(gp1, GamePad.BTN_Y);
		private Button b2_clicR = new JoystickButton(gp1, GamePad.AXISBTN_R);
		private Button b2_clicL = new JoystickButton(gp1, GamePad.AXISBTN_L);
		
		public OI() {
			//JOYSTICK 2************************************************************************************
			b2_sBack.whenPressed(new CycleDriveCommand());
			b_sBack.whenPressed(new CycleDriveCommand());

/*
			
			b2_dpadU.whenPressed(new SetArmPosCommand(2.7));
			b2_dpadD.whenPressed(new SetArmPosCommand(0.7)); //Preferred shooting position
			b2_dpadR.whenPressed(new ShiftCommand());


			b2_bumpR.whenPressed(new SetIntakeCommand(1));
			b2_bumpR.whenReleased(new SetIntakeCommand(0));
			b2_bumpL.whileHeld(new SetIntakeCommand(-1));
			b2_bumpL.whenPressed(new SetIntakeCommand(0));
			
			b2_btnX.whenPressed(new MoveTail(0.2));
			b2_btnA.whenPressed(new IntakeClawCommand());

			
			b2_sStar.whenPressed(new SensorToggle());
			b2_btnY.whenPressed(new ToggleCompressor());
			
			//JOYSTICK 1******************************************************************

			
	

			//b_dpadU.whenPressed(new SetArmPosCommand(3.558));
			//b_dpadL.whenPressed(new SetArmPosCommand(4));
			b_dpadD.whenPressed(new SetArmPosCommand(0.7));
			b_dpadU.whenPressed(new SetArmPosCommand(2.7));

			b_dpadR.whenPressed(new ShiftCommand());
			
			b_bumpR.whileHeld(new SetIntakeCommand(-1)); //pulls ball in
			b_bumpR.whenReleased(new SetIntakeCommand(0));
			b_bumpL.whileHeld(new SetIntakeCommand(1)); //pushes ball out
			b_bumpL.whenReleased(new SetIntakeCommand(0));
			
			b_btnA.whenPressed(new IntakeClawCommand());
		//	b_btnX.whenPressed(new MoveTail(0.2));  //TAIL WAS REMOVED
			
			
			b_sStar.whenPressed(new SensorToggle());
			b_btnY.whenPressed(new ToggleCompressor());
			
			b_btnB.whenPressed(new SetShooter());
			b2_btnB.whenPressed(new SetShooter());

			// This is for the version with single click loading and firing, no whenReleased
		//	b_btnB.whenPressed(new LinearPunchStartCommand());
			//b_btnB.whenReleased(new LinearPunchEndCommand());
		//	b2_bumpR.whenPressed(new LinearPunchStartCommand());
		//	b2_bumpR.whenReleased(new LinearPunchEndCommand());
			
			
			
			
			//b_bumpR.whileHeld(new MoveArmCommand(ArmSubsystem.armSpeed));
//			b_bumpR.whenReleased(new MoveArmCommand(0));
			//b_bumpL.whileHeld(new MoveArmCommand(-ArmSubsystem.armSpeed));
		//	b_bumpL.whenReleased(new MoveArmCommand(0));
			
		//	b_triggerR.whileHeld(new SetIntakeCommandCommand(.5));
		//	b_triggerL.whileHeld(new SetIntakeCommandCommand(-.5));
		*/}
		
		public double getRawAnalogStickALX() {
			if(gp1.getRawAxis(0)>0.1||gp1.getRawAxis(0)<=-0.1)
				return (gp1.getRawAxis(0));
			else
			{
				return (xbox.getRawAxis(0));// left stick y-axis	}
			}
		}
		

		
		public double getRawAnalogStickALY() {
			if(gp1.getRawAxis(1)>0.1||gp1.getRawAxis(1)<=-0.1)
			return gp1.getRawAxis(1);
			else
			return (xbox.getRawAxis(1));// left stick y-axis
		}

		public double getRawAnalogStickARX() {
			if(gp1.getRawAxis(2)>=0.1||gp1.getRawAxis(2)<=-0.1)//changed from 4
			return gp1.getRawAxis(2);
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
			if(gp1.getRawAxis(5)>=0.1||gp1.getRawAxis(5)<=-0.1)
			return -gp1.getRawAxis(5);
			else
			return (-xbox.getRawAxis(5));
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
		public double getRT(){
			if(gp1.getRawAxis(3)<-0.1||gp1.getRawAxis(3)>0.1)
				return gp1.getRawAxis(3);
			else
			return (xbox.getRawAxis(3));
			
		}
		public double getLT(){
			if(gp1.getRawAxis(2)<-0.1||gp1.getRawAxis(2)>0.1)
				return gp1.getRawAxis(2);
			else
			return (xbox.getRawAxis(2));
		} 
	}
//}
