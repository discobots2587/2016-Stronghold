package org.discobots.stronghold;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	
	private static int driveCounter = 0;

	public static void init() {
	}

	public static void update() {
		driveCounter++;
		
		SmartDashboard.putNumber("LPSensor Readout", Robot.linearPunchSub.getLPSensorData());
		if (driveCounter == Integer.MAX_VALUE) {
			driveCounter = 0;
		}

		if (driveCounter % 5 == 0) { // 100ms
			SmartDashboard.putNumber("Robot Loop Execution Time",
					Robot.loopExecutionTime);


		} else if (driveCounter % 5 == 1) {
	//		SmartDashboard.putData("DriveTrainCommand", Robot.driveTrainSub.getCurrentCommand());
		}
	}
}
