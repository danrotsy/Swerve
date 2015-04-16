package org.usfirst.frc.team486.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;

/**
 *
 */
public class Wheel extends PIDSubsystem {
    // Initialize your subsystem here
	static double p = 0.0;
	static double i = 0.0;
	static double d = 0.0;
	Encoder encoder;
	CanTalonSRX cantalonsrx;
	
    public Wheel(Encoder encoder, CanTalonSRX cantalonsrx) {
    	super(p,i,d);
    	this.encoder = encoder;
    	this.cantalonsrx = cantalonsrx;
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return encoder.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	cantalonsrx.Set(output);
    }
}
