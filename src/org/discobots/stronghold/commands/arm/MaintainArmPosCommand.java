package org.discobots.stronghold.commands.arm;

import org.discobots.stronghold.Dashboard;
import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MaintainArmPosCommand extends Command {

	double currentSetpoint;
	double currentPosition;
	double motorSpeed;
	//int i =0;
    public MaintainArmPosCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.armSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentSetpoint = Robot.armSub.potentiometer.getAverageVoltage();
    }

    // Called repeatedly when this Command is scheduled to run
    @SuppressWarnings("deprecation")
	protected void execute() {
    	currentPosition = Robot.armSub.potentiometer.getAverageVoltage();
    	motorSpeed = (currentPosition-currentSetpoint)*Robot.armSub.kP;
    	Robot.armSub.armMotor.set(motorSpeed);
    	/*if (i%100==0)
    	SmartDashboard.putDouble("Arm Motor Direction:", motorSpeed);
    	i++;*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
