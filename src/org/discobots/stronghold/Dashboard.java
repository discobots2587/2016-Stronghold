package org.discobots.stronghold;
import java.util.*;
import java.io.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	
	private static int driveCounter = 0;
	private static ArrayList<Double> pdpPTs = new ArrayList<Double>();
 
	public static void init() {
	}

	public static void update() {
		driveCounter++;
		//pdpPTs.add(Robot.electricalSub.getPDPTotalCurrent());
		if (driveCounter == Integer.MAX_VALUE) {
			driveCounter = 0;
		}

		if (driveCounter % 5 == 0) { // 100ms
			SmartDashboard.putNumber("Robot Loop Execution Time",
					Robot.loopExecutionTime);

		} else if (driveCounter % 5 == 1) {
			//SmartDashboard.putData("DriveTrainCommand", Robot.driveTrainSub.getCurrentCommand());
		
		SmartDashboard.putNumber("Potentiometer", Robot.armSub.potentiometer.getAverageVoltage());
		//SmartDashboard.putNumber("Test PDP", pdpPTs.get(driveCounter-1));
		//SmartDashboard.putNumber("PDP", Robot.electricalSub.getPDPTotalCurrent());
		//SmartDashboard.putNumber("PDP V", Robot.electricalSub.getPDPVoltage());
		//SmartDashboard.putBoolean("BrakeValue", Robot.armSub.getBrake());
		SmartDashboard.putNumber("LPSensor", Robot.linearPunchSub.getLPSensorData());
		SmartDashboard.putString("Sensor Toggle: ", Robot.armSub.SensorToggleS[Robot.armSub.sensorToggle]);
		//SmartDashboard.putNumber("ButtonMoveSpeed", Robot.driveTrainSub.buttonSpeed);
	
		}
		}
}
