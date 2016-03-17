package org.discobots.stronghold.commands.auton.subcommands;

import org.discobots.stronghold.Robot;
import org.discobots.stronghold.commands.drive.SplitArcadeDriveCommand;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousDriveDebug extends Command {
	double x,y;
	long endTime;
	boolean fin=false;
    public AutonomousDriveDebug(double y,double x, int time) {
    	requires(Robot.driveTrainSub);
    	endTime = System.currentTimeMillis()+time;
    	this.x=x;
    	this.y=y;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrainSub);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	for(long currT=System.currentTimeMillis();currT<=endTime;)
    	{
    	Robot.driveTrainSub.setRamped(false);
    	Robot.driveTrainSub.arcadeDriveUnramped(y, x);
    	}
    	Robot.driveTrainSub.arcadeDriveUnramped(0, 0);
		for(long x=System.currentTimeMillis()+2000;x>=System.currentTimeMillis();)
		{
			Robot.driveTrainSub.arcadeDriveUnramped(0.75, 0.75);
		}
    	Robot.driveTrainSub.arcadeDriveUnramped(0, 0);
		for(long x =System.currentTimeMillis()+2000;x>=System.currentTimeMillis();)
		{
			Robot.driveTrainSub.tankDriveUnramped(0.75, 0.75);
		}
    	fin=true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fin;
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
