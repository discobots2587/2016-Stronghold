package org.discobots.stronghold.commands.arm;

import org.discobots.stronghold.Robot;
import org.discobots.stronghold.commands.auton.subcommands.WaitCommand;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SetShooter extends Command {
boolean fin=false;
	public SetShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shootSub);
    	requires(Robot.intakeSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.intakeSub.setIntake(true);
	new WaitCommand(500);
		Robot.shootSub.shooter1.set(true);
		Robot.shootSub.shooter2.set(true);
	
	new WaitCommand(300);
		Robot.shootSub.shooter1.set(false);
		Robot.shootSub.shooter2.set(false);
		Robot.intakeSub.setIntake(false);
	new WaitCommand(500);
	fin=true;
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fin;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.shootSub.SetShooter(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
