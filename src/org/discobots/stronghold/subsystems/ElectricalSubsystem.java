package org.discobots.stronghold.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElectricalSubsystem extends Subsystem {
    
	PowerDistributionPanel pdp;
	Compressor cmp;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ElectricalSubsystem(){
		pdp = new PowerDistributionPanel();
		cmp = new Compressor();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public double getPDPVoltage() {
		return pdp.getVoltage();
	}

	public double getCurrentFromPDPChannel(int channel) {
		return pdp.getCurrent(channel);
	}

	public double getPDPTotalCurrent() {
		double totalCurrent = 0;
		for (int i = 0; i < 16; i++) {
			totalCurrent += pdp.getCurrent(i);
		}
		return totalCurrent;
	}
	public void setCompressor (boolean var){
		if (var){
				cmp.start();
		}else{
				cmp.stop();
		}
	}
	public boolean getCompressorState(){
		return cmp.enabled();
	}
	public boolean getPressureSwitchState(){
		return cmp.getPressureSwitchValue();
	}
	public double getCompressorControlLoopState(){
		return cmp.getCompressorCurrent();
	}
}
	
