
package org.discobots.stronghold;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import java.util.concurrent.TimeUnit;

import org.discobots.stronghold.commands.auton.AutonomousCommand;
import org.discobots.stronghold.commands.auton.DoNothing;
import org.discobots.stronghold.commands.auton.DumbAutonCommand;
import org.discobots.stronghold.commands.auton.DumbPositioningAuton;
import org.discobots.stronghold.commands.auton.Forwards50;
import org.discobots.stronghold.commands.auton.Forwards50Back;
import org.discobots.stronghold.commands.auton.Forwards75;
import org.discobots.stronghold.commands.auton.Forwards75Back;
import org.discobots.stronghold.commands.auton.SimpleDriveAutonomousCommand;
import org.discobots.stronghold.commands.drive.ArcadeDriveCommand;
import org.discobots.stronghold.commands.drive.SplitArcadeDriveCommand;
import org.discobots.stronghold.commands.drive.TankDriveCommand;
import org.discobots.stronghold.subsystems.ArmSubsystem;
//import org.discobots.stronghold.commands.ExampleCommand;
import org.discobots.stronghold.subsystems.DriveTrainSubsystem;
import org.discobots.stronghold.subsystems.ElectricalSubsystem;
import org.discobots.stronghold.subsystems.IntakeSubsystem;
import org.discobots.stronghold.subsystems.LinearPunchSubsystem;
import org.discobots.stronghold.subsystems.ShooterSubsystem;







//import org.discobots.stronghold.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	private CameraServer LogicC615;
	public static double totalTime;
	public static long TeleopStartTime;
	public static long loopExecutionTime = 0;
	public static ShooterSubsystem shootSub;
	public static DriveTrainSubsystem driveTrainSub;
	public static ArmSubsystem armSub;
	public static ElectricalSubsystem electricalSub;
	public static IntakeSubsystem intakeSub;
	public static LinearPunchSubsystem linearPunchSub;
    Command autonomousCommand,driveCommand;
    SendableChooser driveChooser, autonChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public void robotInit() {
    	//init camera and start simple stream process...
   try{ 	LogicC615 = CameraServer.getInstance();//initialize server
    	LogicC615.setQuality(75); //quality setting for camera
        //camera name taken from RoboRio
        USBCamera C615 = new USBCamera("cam0");
       // LogicC615.openCamera();
       // LogicC615.startCapture();
       LogicC615.startAutomaticCapture(C615);//automatically start streaming footage 
   }catch(com.ni.vision.VisionException e){
	    System.err.println("VisionException: " + e.getMessage());
   }

 
    	/* Subsystems */
    	electricalSub = new ElectricalSubsystem();
		driveTrainSub = new DriveTrainSubsystem();
    	armSub = new ArmSubsystem();
    	shootSub = new ShooterSubsystem();
    	intakeSub = new IntakeSubsystem();
    	linearPunchSub = new LinearPunchSubsystem();

    	
    	
    	/* Dashboard Choosers */
    	
    	autonChooser = new SendableChooser();
    	autonChooser.addObject("DumbPostitioningAuton", new DumbPositioningAuton());
		autonChooser.addObject("DumbAuton", new DumbAutonCommand());
		autonChooser.addObject("Auton2", new SimpleDriveAutonomousCommand());
		autonChooser.addDefault("Forwards 75%", new Forwards75());
		autonChooser.addObject("Forwards 75% and BACK", new Forwards75Back());
		autonChooser.addObject("Forwards 50%", new Forwards50());
		autonChooser.addObject("Forwards 50% and BACK", new Forwards50Back());
		autonChooser.addObject("Do Nothing",new DoNothing());
		SmartDashboard.putData("Choose Auton", autonChooser);
		
		driveChooser = new SendableChooser();
		driveChooser.addObject("Tank Drive", new TankDriveCommand());
		driveChooser.addObject("Arcade Drive", new ArcadeDriveCommand());
		driveChooser.addDefault("Split Arcade Drive", new SplitArcadeDriveCommand());
		SmartDashboard.putData("Choose Driving Controls", driveChooser);

        //gamepad mapping
    	oi = new OI();
		
		// dashboard init
		Dashboard.init();
		Dashboard.update();
		
		
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	for (long stop=System.nanoTime()+TimeUnit.SECONDS.toNanos(1);stop>System.nanoTime();) { //rumbles upon disable for 1 second
			oi.setRumble(1);
          }
    	}
	
	public void disabledPeriodic() {
		long start = System.currentTimeMillis();
		Scheduler.getInstance().run();
		Dashboard.update();
		long end = System.currentTimeMillis();
		loopExecutionTime = end - start;
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) autonChooser.getSelected();    	//Starts chosen Auton Command
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	long start = System.currentTimeMillis();
		Scheduler.getInstance().run();
		Dashboard.update();
		long end = System.currentTimeMillis();
		loopExecutionTime = end - start;
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        driveCommand = (Command) driveChooser.getSelected();
		for (long stop=System.nanoTime()+TimeUnit.SECONDS.toNanos(1);stop>System.nanoTime();) { //rumbles upon disable for 1 second
			oi.setRumble(1);
			TeleopStartTime = System.currentTimeMillis();
		}
		if(driveCommand != null) //Starts chosen driving Command
			driveCommand.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	long start = System.currentTimeMillis(); //measures loop execution times
		Scheduler.getInstance().run();
		Dashboard.update();
		long end = System.currentTimeMillis();
		loopExecutionTime = end - start;
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
		long start = System.currentTimeMillis();
    	LiveWindow.run();
		Scheduler.getInstance().run();
		Dashboard.update();
		long end = System.currentTimeMillis();
		loopExecutionTime = end - start;
		totalTime = (double) ((System.currentTimeMillis() - TeleopStartTime)/1000);
    	}
}
