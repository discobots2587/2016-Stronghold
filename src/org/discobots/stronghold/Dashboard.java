package org.discobots.stronghold;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	
	private static int driveCounter = 0;
 
	public static void init() {
	}

	public static void update() {
		driveCounter++;
		if (driveCounter == Integer.MAX_VALUE) {
			driveCounter = 0;
		}

		if (driveCounter % 5 == 0) { // 100ms
			SmartDashboard.putNumber("Robot Loop Execution Time",Robot.loopExecutionTime);
			SmartDashboard.putNumber("Gyro Reading: ",1.1);

		} else if (driveCounter % 5 == 1) {
			SmartDashboard.putData("DriveTrainCommand", Robot.driveTrainSub.getCurrentCommand());
		}
	}
}
