package org.discobots.stronghold.commands.auton;

import org.discobots.stronghold.commands.auton.subcommands.AutonomousArcadeDrive;
import org.discobots.stronghold.commands.auton.subcommands.WaitCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DumbAutonCommand extends CommandGroup {
    int i =1;
    public  DumbAutonCommand() {
        SmartDashboard.putNumber("DumbAuton", i);

        addSequential(new AutonomousArcadeDrive(.75,0,2000));//go under lowbar
        
        addSequential(new WaitCommand(500));// wait .5 seconds
        
        addSequential(new AutonomousArcadeDrive(0,.7,500));// turn right
        
        addSequential(new WaitCommand(500));//wait .5 seconds
        
        addSequential(new AutonomousArcadeDrive(0.5, 0, 1000));//drive towards goal
        
        addSequential(new WaitCommand(500));//wait .5 seconds
        SmartDashboard.putNumber("DumbAuton", i-1);
        //addSequential(new ShootCommand());// shoots at goal
        
        addSequential(new AutonomousArcadeDrive(-0.5, 0, 1000));
        addSequential(new AutonomousArcadeDrive(0,-.9,500));
        addSequential(new AutonomousArcadeDrive(-.75,0,2000));
        
    	//AutonomousArcadeDrive();
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