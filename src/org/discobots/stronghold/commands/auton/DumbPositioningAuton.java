package org.discobots.stronghold.commands.auton;

import org.discobots.stronghold.commands.auton.subcommands.AutonomousArcadeDrive;
import org.discobots.stronghold.commands.auton.subcommands.WaitCommand;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DumbPositioningAuton extends CommandGroup {
    public  DumbPositioningAuton() {
    	addSequential(new AutonomousArcadeDrive(.50,0,4000));//forwards 1/2 speed for 4 seconds until hits wall
    	addSequential(new WaitCommand(500));
    	addSequential(new AutonomousArcadeDrive(-.3,-.5,2000));//back up while turning towards goal
    	addSequential(new WaitCommand(250));
    	addSequential(new AutonomousArcadeDrive(0,.4,1000));//point turn towards goal
    	addSequential(new AutonomousArcadeDrive(.5,0,3000));//forwards towards goal

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
