package org.usfirst.frc.team4585.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
public class Launcher {
	
	int fireValvePort;
	int magazineSolenoidPort;
	
	boolean hasMagazineSolenoid;
	
	Solenoid fireValve;
	Solenoid magazineSolenoid;
	
	public Launcher(int cannonTriggerPort) {
		this.fireValvePort = cannonTriggerPort;	
		
		fireValve = new Solenoid(fireValvePort);
		
		hasMagazineSolenoid = false;
	}
	
	public Launcher(int cannonTriggerPort, int  magazineSolenoidPort) {
		this.fireValvePort = cannonTriggerPort;	
		this.magazineSolenoidPort = magazineSolenoidPort;
		
		fireValve = new Solenoid(fireValvePort);
		magazineSolenoid = new Solenoid(magazineSolenoidPort);
		
		hasMagazineSolenoid = true;
	}
	
	public void setFiring(boolean state) {
		if(state) {
			setAirLoad(false);
			fireValve.set(true);
		}
		else {
			fireValve.set(true);
			setAirLoad(true);
		}
	}
	
	public void fire() {
		timedFire(15);
	}
	public void timedFire(double millis) {
		
		setAirLoad(false);
		fireValve.set(true);
		Timer.delay(millis/1000);
		fireValve.set(true);
		setAirLoad(true);
	}
	
	public void setAirLoad(boolean state) { // true is open, false is closed
		if(hasMagazineSolenoid)
			magazineSolenoid.set(!state);
	}
}









