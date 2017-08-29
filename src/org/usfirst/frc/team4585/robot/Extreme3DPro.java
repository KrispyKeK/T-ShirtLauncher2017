package org.usfirst.frc.team4585.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Extreme3DPro {
	
	private int port;
	
	Joystick joy;
	
	public Extreme3DPro(int port) {
		this.port = port;
		joy = new Joystick(port);
	}
	
	public int getPort() {
		return this.port;
	}
	
	public double getX() {
		return joy.getX();
	}
	
	public double getY() {
		return joy.getY();
	}
	
	public double getZ() {
		return joy.getZ();
	}
	
	public double getThrottle() {
		return -((joy.getThrottle()+1)/2); // maps it from 1:-1 to 0:1
	}
	
	public double getAxis(int axis) {
		return joy.getRawAxis(axis);
	}

	public double getPOV(int pov) {
		return joy.getPOV(pov);
	}
	
	public double getPOV() {
		return joy.getPOV();
	}
	
	public boolean getTrigger() {
		return joy.getRawButton(1);
	}
	
	public boolean getButton(int button) {
		return joy.getRawButton(button);
	}
}
