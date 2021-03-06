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
    	requires(Robot.armSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.armSub.sensorToggle = !Robot.armSub.sensorToggle;
    	if(Robot.armSub.sensorToggle==1)
    		Robot.armSub.sensorToggle=0;
    	else if(Robot.armSub.sensorToggle==0)
    		Robot.armSub.sensorToggle=2;
    	else
    		Robot.armSub.sensorToggle=1;
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
