package org.discobots.stronghold.utils;

import edu.wpi.first.wpilibj.AnalogInput;

public class PressureSensor {

	AnalogInput sensorInput;

	public PressureSensor(int ch) {
		sensorInput = new AnalogInput(ch);//takes analog input
	}

	public double getPSI() {//get pressure method
		double voltage = sensorInput.getAverageVoltage();
		double voltage0to4 = (voltage - 0.5);
		voltage0to4 = (voltage0to4 < 0) ? 0 : voltage0to4;
		return (voltage0to4) * 40.1785714286;
	}

	public double getVoltage() {
		return sensorInput.getAverageVoltage();
	}
}

