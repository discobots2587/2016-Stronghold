package org.discobots.stronghold.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

public class Lidar {
	private static final LidarController lidarController = new LidarController();

	public static class LidarController {
		private I2C i2c;
		private Thread lidarThread;
		private Vector lidarVect;
		private List<Lidar> lidarList;
		private int counter;

		private final int LIDAR_CONFIG_REGISTER = 0x00;
		private final int LIDAR_DISTANCE_REGISTER = 0x8f;
		private final int LIDAR_ADDRESS = 0x62;

		/*
		 * This exists because we have multiple lidars and only one lidar port.
		 * This ensures we poll the i2c address in sequence. Hopefully the
		 * multi-threading works :/
		 */
		public LidarController() {
			i2c = new I2C(Port.kMXP, LIDAR_ADDRESS);
			lidarVect = new Vector();
			lidarList = new ArrayList<Lidar>();//holds lidar objects - each lidar used will be stored here and managed
			counter = 0;
			lidarThread = new Thread() {//thread runs in background simultaneously with other threads

				public void wait(int timeMs) {
					try {
						Thread.sleep(timeMs);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				public void run() {
					while (true) {
						if (lidarVect.size() != 0) {
							Lidar lidar = (Lidar) lidarVect.get(counter);
							if (lidar == null) {
								wait(50);
							} else {
								lidar.setDigOutState(true);
								wait(10);
								byte[] by = new byte[2];
								i2c.write(LIDAR_CONFIG_REGISTER, 0x04);
								wait(30);
								i2c.read(LIDAR_DISTANCE_REGISTER, 2, by);
								int output = (int) Integer.toUnsignedLong(by[0] << 8)
										+ Byte.toUnsignedInt(by[1]);

								lidar.setDistanceCm(output);//output in cm
								lidar.setDigOutState(true);
								counter++;
								if (counter == lidarVect.size()) {
									counter = 0;
								}
							}
						}
					}
				}
			};
			lidarThread.start();
		}

		public void registerLidar(Lidar lidar) {
			lidarVect.add(lidar);//adds a new Lidar object to ArrayList
			//lidarList.add(lidar);
		}
	}

	private double distance;
	private DigitalOutput output;

	public Lidar(int port) {
		this.output = new DigitalOutput(port);
		this.distance = 0;
		lidarController.registerLidar(this); //when instantiated this class is given a port for the lidar 
		//which it assigns to a new lidar object and adds it to the arraylist
	}

	private void setDigOutState(boolean a) {
		output.set(a);
	}

	public synchronized double getDistanceIn() {
		return distance / 2.54; //returns distance in inches
	}

	private synchronized void setDistanceCm(double a) {
		this.distance = a; //sets the distance to a
	}

}