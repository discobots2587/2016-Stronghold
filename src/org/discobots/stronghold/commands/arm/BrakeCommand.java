package org.discobots.stronghold.commands.arm;

import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BrakeCommand extends Command {

	private boolean brakeOn;
	
    public BrakeCommand(boolean x) { //Toggles the brake for the arm
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.armSub);
    	brakeOn = x;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.armSub.setBrake(brakeOn);
    	SmartDashboard.putBoolean("ArmBrake", brakeOn);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.armSub.setBrake(brakeOn);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
