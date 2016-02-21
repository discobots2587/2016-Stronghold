package org.discobots.stronghold.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public abstract class StandardAuton extends CommandGroup {
   String Stage;
    abstract public String getStage();
    abstract public void setStage(String Stage);;
    public void update()
    {
    	SmartDashboard.putString("Stage", getStage());
    };
}
