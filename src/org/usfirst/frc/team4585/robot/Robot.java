package org.usfirst.frc.team4585.robot;

import edu.wpi.first.wpilibj.SampleRobot;

public class Robot extends SampleRobot {
	
	int driveLPort = 0;
	int driveRPort = 1;
	int cannonTriggerPort = 3;
	int climbPort = 2;
	
	int joystickPort = 0;
	
	int climbButton = 2;
	int fireButton = 1;
	
	long time;
	int millisPerIteration = 5;
	
	TankDrive chassis = new TankDrive(driveLPort, driveRPort);
	Extreme3DPro joy = new Extreme3DPro(joystickPort);
	//QDSKeyboard keyboard = new QDSKeyboard(joystickPort);
	Launcher gun = new Launcher(cannonTriggerPort);
	Climber climber = new Climber(climbPort);

	public Robot() {
		
	}

	@Override
	public void robotInit() {
	
	}
	
	@Override
	public void autonomous() {
	
	}

	@Override
	public void operatorControl() {
		time = System.currentTimeMillis();
		while(isEnabled() & isOperatorControl()) {
			if (System.currentTimeMillis() >= time + millisPerIteration) {
				
				chassis.arcadeDrive(-joy.getZ(), joy.getY());
				//chassis.arcadeDrive(keyboard.getAxisAD(), keyboard.getAxisWS());
				
				gun.setFiring(joy.getButton(fireButton));
				
				climber.setSpeed(-joy.getThrottle());
				climber.setClimbing(joy.getButton(climbButton));
				
				time = System.currentTimeMillis();
			}
			
		}
	}

	@Override
	public void test() {
		
	}
}
