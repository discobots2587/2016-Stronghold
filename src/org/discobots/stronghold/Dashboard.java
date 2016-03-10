package org.discobots.stronghold;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class Dashboard {
	
	private static int driveCounter = 0;
	public static CameraServer LogicC615;
    public static USBCamera C615 = new USBCamera("cam0");

	public static void init() {

		LogicC615 = CameraServer.getInstance();//initialize server
    	LogicC615.setQuality(75); //quality setting for camera
        //camera name taken from RoboRio
        C615.openCamera();
        C615.startCapture();
        LogicC615.startAutomaticCapture(C615);//automatically start streaming footage 
        C615.setSize(1920 , 1080);//will need to tweak
        C615.setFPS(30);//will need to tweak
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
		if(driveCounter % 1003 == 0)
		{
	    	if (LogicC615.isAutoCaptureStarted()==false)
	    	{		C615.startCapture();
	    			LogicC615.startAutomaticCapture(C615);
	    	}
		}
	}
}
