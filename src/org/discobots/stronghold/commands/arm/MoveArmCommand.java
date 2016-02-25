package org.discobots.stronghold.commands.arm;

import org.discobots.stronghold.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArmCommand extends Command {

	private double speed;

	public MoveArmCommand(double s) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.armSub);
		requires(Robot.electricalSub);

		speed = s;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.armSub.armMotor.set(speed);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// int channel = Robot.armSub.armMotor.getChannel();
		return true;// Robot.electricalSub.getCurrentFromPDPChannel(channel) <=
		// 0.1;
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
