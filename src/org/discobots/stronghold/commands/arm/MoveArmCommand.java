package org.discobots.stronghold.commands.arm;

import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.CANTalon;
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
    	if(Robot.electricalSub.getCurrentFromPDPChannel(Robot.armSub.armMotor.getChannel()) <= 0.1)
    	{
    		return false;
    	}
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
