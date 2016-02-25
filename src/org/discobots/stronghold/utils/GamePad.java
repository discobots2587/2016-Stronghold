package org.discobots.stronghold.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class GamePad extends Joystick {

	public GamePad(int port) {
		super(port);
	}

	/***** MODE D CONFIGURATION *****/ 
	// Axis
	public static final int AXIS_LX = 0;
	public static final int AXIS_LY = 1;
	public static final int AXIS_RX = 2;
	public static final int AXIS_RY = 3;
	public static final int DPAD_X = 4;
	public static final int DPAD_Y = 5;
	// Buttons
	public static final int BTN_X = 1;
	public static final int BTN_A = 2;
	public static final int BTN_B = 3;
	public static final int BTN_Y = 4;

	public static final int BTN_LB = 5;
	public static final int BTN_LT = 7;
	public static final int BTN_RB = 6;
	public static final int BTN_RT = 8;

	public static final int BTN_BACK = 9;
	public static final int BTN_START = 10;

	public static final int AXISBTN_L = 11;
	public static final int AXISBTN_R = 12;

	public double getLX() {
		return this.getRawAxis(AXIS_LX);
	}

	public double getLY() {
		return this.getRawAxis(AXIS_LY) * -1;
	}

	public double getRX() {
		return this.getRawAxis(AXIS_RX);
	}

	public double getRY() {
		return this.getRawAxis(AXIS_RY) * -1;
	}

	public double getDX() {
		return this.getRawAxis(DPAD_X);
	}

	public double getDY() {
		return this.getRawAxis(DPAD_Y) * -1;
	}

	public static class DPadButton extends Button {
		public static final double kDefaultThreshold = 0.7;
		private GamePad m_gp;
		private int m_buttonAxis;
		private boolean positive;

		public DPadButton(GamePad gp, int buttonAxis, boolean positive) {
			this(gp, buttonAxis, kDefaultThreshold, positive);
		}

		public DPadButton(GamePad gp, int buttonAxis, double threshold, boolean positive) {
			m_gp = gp; 
			m_buttonAxis = buttonAxis;
			this.positive = positive;
		}

		public void setThreshold(double threshold) {
		}

		public boolean get() {

			if (positive) {
				if (m_buttonAxis == GamePad.DPAD_X) {
					return m_gp.getPOV() == 90;
				} else if (m_buttonAxis == GamePad.DPAD_Y) {
					return m_gp.getPOV() == 0;
				}
			} else {
				if (m_buttonAxis == GamePad.DPAD_X) {
					return m_gp.getPOV() == 270;
				} else if (m_buttonAxis == GamePad.DPAD_Y) {
					return m_gp.getPOV() == 180;
				}
			}
			return false;
		}

	}

}