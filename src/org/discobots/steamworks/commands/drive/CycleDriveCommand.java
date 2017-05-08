package org.discobots.steamworks.commands.drive;

import org.discobots.steamworks.Robot;
import org.discobots.steamworks.commands.drive.ArcadeDriveCommand;
import org.discobots.steamworks.commands.drive.SplitArcadeDriveCommand;
//import org.discobots.steamworks.commands.drive.TankDriveCommand;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CycleDriveCommand extends Command {
	Command cmd2;
	boolean isDef=false;

	
public CycleDriveCommand() {
	}

public CycleDriveCommand(char charCmd) {

	isDef=true;
		if(charCmd=='S')
		{
			cmd2=new TankDriveCommand();
		}
		if(charCmd=='A')
		{
			cmd2=new SplitArcadeDriveCommand();
		}
		if(charCmd=='T')
		{
			cmd2=new ArcadeDriveCommand();
		}
	}


	// Called just before this Command runs the first time
	protected void initialize() {
		if(isDef==false)
		cmd2 = Robot.driveTrainSub.getCurrentCommand();	

												//swap commands with a single button
		if (cmd2 instanceof SplitArcadeDriveCommand) {
			new ArcadeDriveCommand().start();
			 SmartDashboard.putString("Current Drive: ", "Arcade Drive");	
			 
		} else if (cmd2 instanceof TankDriveCommand) {
			new SplitArcadeDriveCommand().start();

		} 
		else
		{
			SmartDashboard.putString("Current Drive: ", "Tank Drive");	
			new TankDriveCommand().start();
		}
	
		//swap commands with a single button
/*
		if (cmd2 instanceof SplitArcadeDriveCommand) {
			new ArcadeDriveCommand().start();
			 SmartDashboard.putString("Current Drive: ", "Arcade Drive");	
		}
		else
		{
			new SplitArcadeDriveCommand().start();
			 SmartDashboard.putString("Current Drive: ", "Split Arcade Drive");	

		}
	}*/
	}
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		end();
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
