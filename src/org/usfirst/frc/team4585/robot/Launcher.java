package org.usfirst.frc.team4585.robot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;

public class Launcher {
	
	int fireValvePort;
	int magazineSolenoidPort;
	
	boolean hasMagazineSolenoid;
	
	Relay fireValve;
	Solenoid magazineSolenoid;
	
	public Launcher(int cannonTriggerPort) {
		this.fireValvePort = cannonTriggerPort;	
		
		fireValve = new Relay(fireValvePort);
		
		hasMagazineSolenoid = false;
	}
	
	public Launcher(int cannonTriggerPort, int  magazineSolenoidPort) {
		this.fireValvePort = cannonTriggerPort;	
		this.magazineSolenoidPort = magazineSolenoidPort;
		
		fireValve = new Relay(fireValvePort);
		magazineSolenoid = new Solenoid(magazineSolenoidPort);
		
		hasMagazineSolenoid = true;
	}
	
	public void setFiring(boolean state) {
		if(state) {
			fireValve.set(Relay.Value.kOn);
			setMagazineState(false);
		}
		else {
			fireValve.set(Relay.Value.kOff);
		}
	}
	
	public void fire() {
		timedFire(15);
	}
	public void timedFire(double millis) {
		
		fireValve.set(Relay.Value.kOn);
		Timer.delay(millis/1000);
		fireValve.set(Relay.Value.kOff);
		
	}
	
	public void setMagazineState(boolean state) {
		if(hasMagazineSolenoid)
			magazineSolenoid.set(state);
	}
}









