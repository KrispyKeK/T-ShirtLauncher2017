package org.usfirst.frc.team4585.robot;

import edu.wpi.first.wpilibj.Spark;


public class Climber {
	
	double speed = 0;
	double speedCoeff = -1; 
	Spark motor;
	boolean isClimbing=false;
	boolean inverted = false;

	public Climber(int port) {
		motor = new Spark(port);
	}

	public void setClimbing(boolean climb) {
		this.isClimbing=climb;
		if (this.isClimbing) {
			if(inverted)
				motor.set(-speed * speedCoeff);
			else
				motor.set(speed * speedCoeff);
		}
		else
			motor.set(0);
	}
	
	public void setInverted(boolean inverted) {
		this.inverted = inverted;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getSpeed(){
		return this.speed;
	}
	
	public double getSpeedCoeff(){
		return this.speedCoeff;
	}
	
	public boolean getClimb(){
		return this.isClimbing;
	}
}
