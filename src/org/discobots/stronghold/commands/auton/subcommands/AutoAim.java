package org.discobots.stronghold.commands.auton.subcommands;

import org.discobots.stronghold.Robot;
import org.discobots.stronghold.subsystems.AutoAimSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoAim extends Command {
	int direction;
	int auton;
    public AutoAim() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    public AutoAim(int direction, int auton)
    {
    	requires(Robot.autoAimSys);
    	this.auton=auton;
    	this.direction=direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.autoAimSys.aimingAllowed()==false)
    	{
    		Robot.autoAimSys.resetAim();
    	}
    	if (auton==1)//if toggled by AUTON MODE
    	{
    		Robot.autoAimSys.setAutonAIM(true);
    	} 
    	else if(auton==2)//if toggled by USER
    	{
    		Robot.autoAimSys.setAutonAIM(true);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
