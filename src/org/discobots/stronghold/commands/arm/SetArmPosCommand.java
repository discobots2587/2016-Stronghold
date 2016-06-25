package org.discobots.stronghold.commands.arm;

import org.discobots.stronghold.Robot;
import org.discobots.stronghold.utils.LTRTXBOX;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetArmPosCommand extends Command {
	
	double currentSetpoint;
	double currentPosition;
	double motorSpeed;

    public SetArmPosCommand(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	currentSetpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	new BrakeCommand(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentPosition = Robot.armSub.potentiometer.getAverageVoltage();
    	motorSpeed = -1*(currentPosition-currentSetpoint);
    	if(motorSpeed>.1||motorSpeed*-1>.1)
    		motorSpeed*=Robot.armSub.kP;   		
    	Robot.armSub.armMotor.set(motorSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return currentPosition <= currentSetpoint +.7 && currentPosition >= currentSetpoint - 0.7;
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
