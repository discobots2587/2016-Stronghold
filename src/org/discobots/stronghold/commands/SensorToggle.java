package org.discobots.stronghold.commands;

import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SensorToggle extends Command {

    public SensorToggle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.armSub.sensorToggle==2)
    			{
    				Robot.armSub.sensorToggle=1;
    			}
    	else if (Robot.armSub.sensorToggle==1)
    	{
    		Robot.armSub.sensorToggle=0;
    	}
    	else
    	{
    		Robot.armSub.sensorToggle=2;
    	}
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
