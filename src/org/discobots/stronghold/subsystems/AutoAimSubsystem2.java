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
	private boolean autonAIM;
	private Lidar AimLidar;
	private int direction;
	private final int TopGoalWidth=50;//goal width unknown.....
	private final int BottomGoalWidth=40;//goal width unknown.....
	private final int distMax=5000;//max distance threshold
	private final int distMin=200;//min distance threshold
	private final int offsetInch=3; //distance from lidar to end of robot
	private boolean useLidar = false;
	private boolean interrupt=false;
	private Thread aiming;
	public AutoAimSubsystem2()
	{
	AimLidar = new Lidar(HW.i2cLidarAddress);
	aiming = new Thread()
	{
		public void run()
		{
			while (interrupt != true){
				if (useLidar==true)
				{	
					if (autonAIM)
					{
						
					}
					
					else if (direction==-1)
					{
						
					}
					else if(direction==0)
					{
						
					}
					else if(direction ==1)
					{
						
					}
				}
			}
		}
	};aiming.run();
	}
    
	public void SetAutonAIM()
	{
		autonAIM =true;
	}
	public boolean aimingAllowed()
	{
		return !interrupt;
	}
	public void interruptAim()
	{
		interrupt = true;
	}
	public void resetAim()
	{
		interrupt=false;
		useLidar=false;
		aiming.run();
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

	public void disableLidar() {
		useLidar = false;
	}
	public void enableLidar()
	{
		useLidar = true;
	}
	public boolean UseLidar() {
		return useLidar;
	}
    
    
}

