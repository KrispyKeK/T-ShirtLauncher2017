package org.usfirst.frc.team4585.robot;

import edu.wpi.first.wpilibj.Spark;



public class Climber {
	
	double speed = 0;
	int speedCoeff = 1; // this is here to reverse the motor if needed
	Spark motor;
	boolean isClimbing=false;

	public Climber(int port) {
		motor = new Spark(port);
	}

	public void setClimbing(boolean climb) {
		this.isClimbing=climb;
		if (this.isClimbing)
			motor.set(speed * speedCoeff);
		else
			motor.set(0);
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void update() {
		if (isClimbing)
			motor.set(speed * speedCoeff);
		else
			motor.set(0);
	}
	
	public double getSpeed(){
		return this.speed;
	}
	
	public double getSpeedCoeff(){
		return this.speedCoeff;
	}
	
	public boolean getClimb(){
		return this.climb;
	}
}
