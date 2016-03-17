package org.discobots.stronghold.commands.auton;

import org.discobots.stronghold.Robot;
import org.discobots.stronghold.commands.auton.subcommands.AutonomousArcadeDrive;
import org.discobots.stronghold.commands.auton.subcommands.AutonomousDriveDebug;
import org.discobots.stronghold.commands.auton.subcommands.WaitCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Forwards75DebugWithTankDrive extends CommandGroup {
    
    public  Forwards75DebugWithTankDrive() {
    		addSequential(new AutonomousArcadeDrive(0.75,0.75,1000));
    		addSequential(new WaitCommand(2000));
    		for(long x =System.currentTimeMillis()+2000;x<System.currentTimeMillis();)
    		{
    			Robot.driveTrainSub.arcadeDriveUnramped(0.75, 0.75);
    		}
    		addSequential(new WaitCommand(2000));
    		for(long x =System.currentTimeMillis()+2000;x<System.currentTimeMillis();)
    		{
    			Robot.driveTrainSub.tankDriveUnramped(0.75, 0.75);
    		}
    		addSequential(new WaitCommand(2000));
    		addSequential(new AutonomousDriveDebug(1,1,4000));
    		
    		
    		
    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
