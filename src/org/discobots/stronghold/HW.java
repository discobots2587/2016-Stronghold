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
	public final static int motorFrontLeft = 32;
	public final static int motorFrontRight = 35;
	public final static int motorBackLeft = 33;
	public final static int motorBackRight = 30;
	/* PWM */

	public final static int armMotor = 2;
	public final static int intakeMotor = 1;

	
	/* Pneumatics */
	
	/* Analog */
	public final static int potentiometer = 0;
}
