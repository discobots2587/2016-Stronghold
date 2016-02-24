package org.discobots.stronghold.commands.drive;

import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveRobotForward extends Command {

	private float endTime;
	private int time;
	
	
    public MoveRobotForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrainSub);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time = Robot.driveTrainSub.autonTimeTest;
    	endTime = time + System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.driveTrainSub.arcadeDriveRamp(-Robot.driveTrainSub.buttonSpeed, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !(System.currentTimeMillis()<=endTime);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrainSub.arcadeDriveUnramped(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
