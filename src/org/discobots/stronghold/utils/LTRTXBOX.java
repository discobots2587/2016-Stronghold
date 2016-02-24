package org.discobots.stronghold.utils;


import org.discobots.stronghold.Robot;
import org.discobots.stronghold.commands.arm.BrakeCommand;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LTRTXBOX extends Command {
	
	double Liftspeed;
	public double startLift;
	public int time;
	public float endTime;

    public LTRTXBOX() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.armSub);
    	startLift = .7;
    	time = 500;
    	endTime = (System.currentTimeMillis()+time);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if(System.currentTimeMillis()<=endTime){
    			Robot.armSub.setSpeed(startLift);
    		}
    	
    	   Liftspeed = Robot.oi.getRT()-Robot.oi.getLT();//constantly updates every 20 miliseconds
    	   Robot.armSub.setSpeed(Liftspeed);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Liftspeed=0;//always set speeds to zero in end
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Liftspeed=0;
    }
}
