package org.discobots.stronghold.commands.auton.subcommands;

import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */



public class AutonArm extends Command {
	int time;
	public long endTime;
	double s;

    public AutonArm(int t, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.armSub);
    	s = speed;
    	time = t;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	endTime = System.currentTimeMillis()+time;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.armSub.armMotor.set(s);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis()>=endTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.armSub.armMotor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
