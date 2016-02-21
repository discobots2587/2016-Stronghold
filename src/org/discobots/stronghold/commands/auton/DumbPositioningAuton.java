package org.discobots.stronghold.commands.auton;

import org.discobots.stronghold.commands.auton.subcommands.AutonomousArcadeDrive;
import org.discobots.stronghold.commands.auton.subcommands.WaitCommand;

/**
 *
 */
public class DumbPositioningAuton extends StandardAuton {
    private String stage="none";
    public  DumbPositioningAuton() {
    	setStage(("1: forwards"));
    	addSequential(new AutonomousArcadeDrive(.75,0,2000));//forwards 3/4 speed for 2 seconds until hits wall
    	setStage(("wait"));
    	addSequential(new WaitCommand(500));
    	setStage(("2: backing up"));
    	addSequential(new AutonomousArcadeDrive(-.4,-.4,2000));//back up while turning towards goal
    	setStage(("wait"));
    	addSequential(new WaitCommand(250));
    	setStage(("3: Towards Goal"));
    	addSequential(new AutonomousArcadeDrive(0,.4,1000));//forwards while turning towards goal
    	setStage(("complete"));
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
    @Override
	public String getStage() {
		return stage;
	}
    @Override
	public void setStage(String stage) {
		this.stage = stage;
		update();
	}
	

}
