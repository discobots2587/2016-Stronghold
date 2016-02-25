package org.discobots.stronghold.commands.drive;

import org.discobots.stronghold.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CycleDriveCommand extends Command {

	public CycleDriveCommand() {
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Command driveCmd = Robot.driveTrainSub.getCurrentCommand();//swap commands with a single button
		if (driveCmd instanceof SplitArcadeDriveCommand) {
			new TankDriveCommand().start();
		} else if (driveCmd instanceof TankDriveCommand) {
			new ArcadeDriveCommand().start();
		} 
		else
		{
			new SplitArcadeDriveCommand().start();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}//do nothing

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
