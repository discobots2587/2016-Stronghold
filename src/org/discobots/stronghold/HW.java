package org.discobots.stronghold;
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
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	/* CAN */// Check roboRio web interface for these values
	public final static int motorFrontLeft = 20;//set
	public final static int motorFrontRight = 150;//set
	public final static int motorBackLeft = 100;//set
	public final static int motorBackRight = 140;//set
	public final static int motorPunch = 130;
	/* PWM */

	public final static int armMotor = 20;//set
	public final static int intakeMotor = 120;//set
	public final static int shooter = 130;//set
	public final static int servo = 20;

	
	/* Pneumatics */
	public final static int brakeSolenoid = 20;
	public final static int intakeSolenoid = 30;
	
	/* Analog */
	public final static int potentiometer = 4;
	public final static int LPSensor = 20;
	public final static int LoadedSensor = 30; 
	public final static int limitSwitchFront = 20;
	public final static int limitSwitchBack = 201;

}
