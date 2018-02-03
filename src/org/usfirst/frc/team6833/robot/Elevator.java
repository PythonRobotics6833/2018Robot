package org.usfirst.frc.team6833.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Encoder;

public class Elevator {
  private double kp;
  private double ki;
  private double kd;

  public final int TOP = 0;
  public final int BOT = 1;
  public final int SWITCH = 2;
  public final int SCALE = 3;
  public final int VAULT = 4;
  // position values linked to the index of the above named constants
  private final double setpoints[] = {0.0, 0.0, 0.0, 0.0, 0.0};

  private DigitalInput switchBot;
  private DigitalInput switchTop;

  private Victor liftMotor;


  public Elevator(int liftMotorPort, int switchBotPort, int switchTopPort) {
    liftMotor = new Victor(liftMotorPort);
    switchBot = new DigitalInput(switchBotPort);
    switchTop = new DigitalInput(switchTopPort);
    kp = 0.0;
    ki = 0.0;
    kd = 0.0;

  }

  public Elevator(int liftMotorPort, int switchBotPort, int switchTopPort, double kp, double ki, double kd) {
    liftMotor = new Victor(liftMotorPort);
    switchBot = new DigitalInput(switchBotPort);
    switchTop = new DigitalInput(switchTopPort);
    this.kp = kp;
    this.ki = ki;
    this.kd = kd;
  }

  public double getKp() {
    return kp;
  }

  public double getKi() {
    return ki;
  }

  public double getKd() {
    return kd;
  }

  public void setKp(double kp) {
    this.kp = kp;
  }

  public void setKi(double ki) {
    this.ki = ki;
  }

  public void setKd(double kd) {
    this.kd = kd;
  }

  public void setSetpoint(double pos) {

  }

  public void setSetpoint(int namedPos) {
    if (namedPos >= 0 && namedPos < setpoints.length) {
      setSetpoint(setpoints[namedPos]);
    }else {
      System.err.println("Error: Setpoint accessing a value outside of the setpoints array index " +
                         "range. Not updating setpoint.");
    }
  }
}
