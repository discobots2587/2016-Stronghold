package org.discobots.stronghold.utils;

import org.discobots.stronghold.Robot;
import org.discobots.stronghold.commands.arm.MaintainArmPosCommand;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LTRTXBOX extends Command {//*********************must be set to default command in subsystem************************************************
	private double ArmSpeed;

	public LTRTXBOX() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(Robot.armSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {//uses values from right/left xbox controllers to do stuff...
    	   ArmSpeed = Robot.oi.getRT()-Robot.oi.getLT();//constantly updates every 20 miliseconds
    	   if (-0.1<ArmSpeed&&ArmSpeed<0.1)
    	   {
    		   if (-0.1>(Robot.oi.getLogicRT()-Robot.oi.getLogicLT())||(Robot.oi.getLogicRT()-Robot.oi.getLogicLT())>0.1||(Robot.oi.getLogicRT()-Robot.oi.getLogicLT())==0)
    		   {
    			   ArmSpeed=(Robot.oi.getLogicRT()-Robot.oi.getLogicLT());
    		   }
    	   }
    	   Robot.armSub.setSpeed(ArmSpeed);
    	   if(ArmSpeed<0.1)
    	   {
    		   new MaintainArmPosCommand();
    	   }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//always set speeds to zero in end
    	Robot.armSub.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
