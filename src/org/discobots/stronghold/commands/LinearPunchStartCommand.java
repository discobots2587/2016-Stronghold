package org.discobots.stronghold.commands;


import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LinearPunchStartCommand extends Command {

    public LinearPunchStartCommand() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.linearPunchSub);
    	//SmartDashboard.putNumber("Test", 9);

        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.linearPunchSub.pull(1.0, false);
    	//check position (once optical is ready)
    //	SmartDashboard.putNumber("Test", 7);
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() { 
    	//Robot.linearPunchSub.pull(1.0, isFinished());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//this.end();
    	return true;
        //return Robot.linearPunchSub.isReady();
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.linearPunchSub.pull(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
