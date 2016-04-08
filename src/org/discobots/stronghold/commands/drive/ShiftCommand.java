package org.discobots.stronghold.commands.drive;

import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftCommand extends Command {

    public ShiftCommand() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.driveTrainSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	if (Robot.driveTrainSub.getShiftMode()==0)
    	{
    		Robot.driveTrainSub.setShifter(true);
    		Robot.driveTrainSub.setShiftMode(1);
    	}
    	else
    	{
    		Robot.driveTrainSub.setShifter(false);
    		Robot.driveTrainSub.setShiftMode(0);
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
