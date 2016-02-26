package org.discobots.stronghold.utils;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LTRTXBOX extends Command {//*********************must be set to default command in subsystem************************************************
	public LTRTXBOX() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {//uses values from right/left xbox controllers to do stuff...
		//    	   Liftspeed = Robot.oi.getRT()-Robot.oi.getLT();//constantly updates every 20 miliseconds
		//    	   Robot.liftSub.setSpeed(Liftspeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		//always set speeds to zero in end
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {

	}
}
