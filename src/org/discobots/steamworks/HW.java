package org.discobots.steamworks;

import com.ctre.CANTalon;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class HW {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example, with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	/* CAN */// Check roboRio Web Interface for these values
		public final static int  motorFrontLeft = (20);
	 public final static int motorFrontRight = (15);
	 public final static int motorBackLeft = (1);
	 public final static int motorBackRight = (14);
	
	/* PWM */

	public final static int Motor = 2;//set


	
	/* Pneumatics */
	public final static int shooter1 = 6;//set
	public final static int shooter2 = 7;//set


	
	
	/* Analog */
	public final static int potentiometer = 0;
	public final static int pressureSensor=1;

	
	/* Digital */
	public final static int digitalSwitch = 0;

}
