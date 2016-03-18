package org.discobots.stronghold.commands.intake;

import org.discobots.stronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveTail extends Command {
	int time=1000;
	double speed;
	long endTime;
	boolean fin=false;
	boolean toggle =false;
    public MoveTail(double speed,int time) {
        this.time=time;
        this.speed=speed;
    	
    }
    public MoveTail(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.speed=speed;
    	toggle=true;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	endTime=System.currentTimeMillis()+time;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    if(toggle==true)
    {
    	while(System.currentTimeMillis()<=endTime)
    	{
    		Robot.intakeSub.toggleTail(speed);
    	}
    }
    else
    {
    	while(System.currentTimeMillis()<=endTime)
    	{
    		Robot.intakeSub.setTail(speed);
    	}
    }
    	fin=true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fin;
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.intakeSub.setTail(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
