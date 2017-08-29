package org.usfirst.frc.team4585.robot;

import edu.wpi.first.wpilibj.RobotDrive;

public class TankDrive {
	
	private int motorLeft;
	private int motorRight;
	private RobotDrive chassis;
	
	private double coeffX = 1;
	private double coeffY = 1;
	private double scaleX = 2;
	private double scaleY = 2;
	private double deadX = .10;
	private double deadY = .10;
	
	public TankDrive(int leftPort, int rightPort) {
		motorLeft = leftPort;
		motorRight = rightPort;
		chassis = new RobotDrive(motorLeft, motorRight);
		chassis.setExpiration(.1);
	}
	
	public void arcadeDrive(double magX, double magY) { // x is rotation, y is forward/back
		magX = applyDeadzone(magX, deadX);
		magY = applyDeadzone(magY, deadY);
		
		magX = applyCoeff(magX, coeffX);
		magY = applyCoeff(magY, coeffY);
		
		magX = applyScale(magX, scaleX);
		magY = applyScale(magY, scaleY);
		
		chassis.arcadeDrive(magY, magX);
	}
	
	private double applyDeadzone(double input, double deadzone) {
		if(Math.abs(input) >= deadzone) {
			return input;
		}
		else {
			return 0;
		}
	}
	
	private double applyCoeff(double input, double coeff) {
		return input*coeff;
	}
	
	private double applyScale(double input, double power) {
		return Math.copySign(Math.pow(input, power), input);
	}
}















