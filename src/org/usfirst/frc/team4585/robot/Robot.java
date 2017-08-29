package org.usfirst.frc.team4585.robot;

import edu.wpi.first.wpilibj.SampleRobot;

public class Robot extends SampleRobot {
	
	int driveLPort = 1;
	int driveRPort = 0;
	int cannonTriggerPort = 2;
	int climbPort = 3;
	
	int joystickPort = 0;
	
	int climbButton = 2;
	int fireButton = 1;
	
	long time;
	int millisPerIteration = 5;
	
	TankDrive chassis = new TankDrive(driveLPort, driveRPort);
	Extreme3DPro joy = new Extreme3DPro(joystickPort);
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
				
				chassis.arcadeDrive(joy.getX(), joy.getY());
				
				gun.setFiring(joy.getButton(fireButton));
				
				climber.setSpeed(joy.getThrottle());
				climber.setClimbing(joy.getButton(climbButton));
				
				time = System.currentTimeMillis();
			}
			
		}
	}

	@Override
	public void test() {
		
	}
}
