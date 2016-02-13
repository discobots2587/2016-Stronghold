package org.discobots.stronghold.subsystems;

import javax.management.monitor.StringMonitor;

import org.discobots.stronghold.utils.Lidar;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutoAimSubsystem extends PIDSubsystem {
	private Lidar AimLidar;
	int distMax;//max distance threshold
	int distMin;//min distance threshold
	int offsetInch=3; //distance from lidar to end of robot
	public static final double kP = 1.0 / 4.0, kI = 0, kD = 0;

	
	PIDOutput output;
	PIDSource source;
	
	private double setpointSpeed;
	private boolean useLidar = true;// set this to false to disable the lidar

    public AutoAimSubsystem() {
		super(kP, kI, kD);
		
		setpointSpeed = 0;

		this.setAbsoluteTolerance(1);
    	this.setOutputRange(-1, 1);
    }
    

	public double getDistInches() {
		return (AimLidar.getDistanceIn() + offsetInch);
	}  

	// Put methods for controlling this subsystem
    // here. Call these from Commands
	
	//public boolean () {
		//if (useLidar) {
	//		return !limitTop.get() || getLiftHeightInches() > LiftSubsystem.kMaxHeight;
	//	} else {
	//		return !limitTop.get();
	//	}
//	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}
}

