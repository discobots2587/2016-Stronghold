package org.discobots.stronghold.commands.auton;

import org.discobots.stronghold.commands.auton.subcommands.AutonomousArcadeDrive;
import org.discobots.stronghold.commands.auton.subcommands.AutonomousSetIntake;
import org.discobots.stronghold.commands.auton.subcommands.WaitCommand;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DumbAutonCommand extends CommandGroup{
    public  DumbAutonCommand() {

        addSequential(new AutonomousArcadeDrive(.5,0,2000));//go under lowbar
        
        addSequential(new WaitCommand(1500));// wait .5 seconds
        
        addSequential(new AutonomousArcadeDrive(0,.4,1000));// turn right
        
        addSequential(new WaitCommand(1500));//wait .5 seconds
        
        addSequential(new AutonomousArcadeDrive(0.5, 0, 1000));//drive towards goal
        
        addSequential(new AutonomousSetIntake(-1,2000));
        
        addSequential(new WaitCommand(2500));//wait .5 seconds
        //addSequential(new ShootCommand());// shoots at goal
        
        addSequential(new AutonomousArcadeDrive(-0.5, 0, 1000));
        addSequential(new AutonomousArcadeDrive(0,-.5,1000));
        addSequential(new AutonomousArcadeDrive(-.55,0,2000));
        
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