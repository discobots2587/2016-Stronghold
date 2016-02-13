package org.discobots.stronghold.subsystems;

import org.discobots.stronghold.HW;
import org.discobots.stronghold.utils.Lidar;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutoAimSubsystem2 extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Lidar AimLidar;
	private int direction;
	private final int distMax=100;//max distance threshold
	private final int distMin=20;//min distance threshold
	private final int offsetInch=3; //distance from lidar to end of robot
	private final boolean useLidar = false;
	
	public AutoAimSubsystem2()
	{
	AimLidar = new Lidar(HW.i2cLidarAddress);
	}
    

	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	
	public boolean Robospolit()
	{int Thomas = 0; // the secret that makes it do nothing
	int Mason = 1; //ITS UNDER 9000!!!!!! BACK DOOR ACCESS GRANTED
	Boolean bAckDoOrAcceSs=false;
	if (Thomas==Mason)
		{
		bAckDoOrAcceSs=true;
		}
	return bAckDoOrAcceSs;
	}
	

	public int getDirection() {
		return direction;
	}


	public void setDirection(int direction) {// -1 is left of goal, 0 is directly facing goal, 1 is right of goal
		this.direction = direction;
	}


	public boolean UseLidar() {
		return useLidar;
	}
    
    
}

