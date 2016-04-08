package org.discobots.stronghold.commands.auton.subcommands;

import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousSetIntake extends Command {

	private double intakeSpeed;
	private int time;//ms
	long start;
	long end;
    public AutonomousSetIntake(double speed, int time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.time=time;
    	requires(Robot.intakeSub);
    	intakeSpeed=speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	end = System.currentTimeMillis()+time;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.intakeSub.setIntakeSpeed(intakeSpeed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis()>=end;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intakeSub.setIntakeSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
