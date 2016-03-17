package org.discobots.stronghold.commands.auton.subcommands;

import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonomousArcadeDrive extends Command {
	
	private int time;
	private long endTime;
	private double speedY, speedX;
	private boolean fin=false;
	public boolean end=false;
	
    public AutonomousArcadeDrive(double y, double x, int t) {//t is in milliseconds
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrainSub);
    	speedY = y;
    	speedX = x;
    	time = t;
    	endTime = System.currentTimeMillis() + time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		SmartDashboard.putBoolean("AutonomousArcadeEndTimeReached: ", end);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	for(long i =System.currentTimeMillis();i<=endTime;)
    	{
    	Robot.driveTrainSub.robotDrive.arcadeDrive(speedY, speedX);
    	}
    	end =true;
    	fin=true;
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return fin;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrainSub.robotDrive.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}