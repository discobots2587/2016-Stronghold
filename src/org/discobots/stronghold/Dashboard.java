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
		if (driveCounter == Integer.MAX_VALUE) {
			driveCounter = 0;
		}

		if (driveCounter % 5 == 0) { // 100ms
			SmartDashboard.putNumber("Robot Loop Execution Time",
					Robot.loopExecutionTime);


		} else if (driveCounter % 5 == 1) {
			SmartDashboard.putData("DriveTrainCommand", Robot.driveTrainSub.getCurrentCommand());
		}
		
		pdpPTs.add(Robot.electricalSub.getPDPTotalCurrent());
		
		SmartDashboard.putNumber("Test PDT", pdpPTs.get(driveCounter));
	}
}
