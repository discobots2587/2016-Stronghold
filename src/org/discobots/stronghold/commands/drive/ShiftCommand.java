package org.discobots.stronghold.commands.drive;

import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftCommand extends Command {

    public ShiftCommand() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.driveTrainSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.driveTrainSub.getShifter().equals(DoubleSolenoid.Value.kForward))
    		Robot.driveTrainSub.setShifter(DoubleSolenoid.Value.kReverse);
    	else if(Robot.driveTrainSub.getShifter().equals(DoubleSolenoid.Value.kReverse))
    		Robot.driveTrainSub.setShifter(DoubleSolenoid.Value.kForward);
    	else
    		Robot.driveTrainSub.setShifter(DoubleSolenoid.Value.kOff);
    	
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
