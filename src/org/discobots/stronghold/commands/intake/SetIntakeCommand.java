package org.discobots.stronghold.commands.intake;

import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetIntakeCommand extends Command {

	private double intakeSpeed;
	
    public SetIntakeCommand(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intakeSub);
    	intakeSpeed=speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intakeSub.setIntakeSpeed(intakeSpeed);
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
    	Robot.intakeSub.setIntakeSpeed(intakeSpeed);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
