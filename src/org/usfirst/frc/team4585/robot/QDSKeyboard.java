package org.usfirst.frc.team4585.robot;

import edu.wpi.first.wpilibj.Joystick;

public class QDSKeyboard {
	
	private int port;
	
	Joystick joy;
	
	public QDSKeyboard(int port) {
		this.port = port;
		joy = new Joystick(port);
	}
	public int getPort() {
		return this.port;
	}
	
	public double getAxisAD() {
		return joy.getRawAxis(0);
	}
	
	public double getAxisWS() {
		return joy.getRawAxis(1);
	}
	
	public double getAxisQE() {
		return joy.getRawAxis(2);
	}
	
	public double getAxisUO() {
		return joy.getRawAxis(3);
	}
	
	public double getAxisLJ() {
		return joy.getRawAxis(4);
	}
	
	public double getAxisKI() {
		return joy.getRawAxis(5);
	}
	
	public boolean getKeypad(int number) {
		return joy.getRawButton(number);
	}
	
	public boolean getArrowKey(String direction) {
		int POV = joy.getPOV();
		switch (direction.toLowerCase()){
			case "up":
				if(POV==360) return true;
				break;
			case "down":
				if(POV==180) return true;
				break;
			case "left":
				if(POV==270) return true;
				break;
			case "right":
				if(POV==90) return true;
				break;	
		}
		return false;
		
	}

}
