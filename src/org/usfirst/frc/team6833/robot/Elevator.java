package org.usfirst.frc.team6833.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.*;

public class Elevator {
  private double kp;
  private double ki;
  private double kd;

  //should be .25 but Burak wants to break bumbers so Just Monika
  private double speed=0.3;

  public final int TOP = 0;
  public final int BOT = 1;
  public final int SWITCH = 2;
  public final int SCALE = 3;
  public final int VAULT = 4;
  // position values linked to the index of the above named constants
  private final double setpoints[] = {0.0, 0.0, 0.0, 0.0, 0.0};

  private DigitalInput switchBot;
  private DigitalInput switchTop;

  private VictorSP liftMotor1;
  private VictorSP liftMotor2;


  public Elevator(int liftMotorPort1, int liftMotorPort2) {
    liftMotor1 = new VictorSP(liftMotorPort1);
    liftMotor2=new VictorSP(liftMotorPort2);

    //switchBot = new DigitalInput(switchBotPort);
    //switchTop = new DigitalInput(switchTopPort);
    kp = 0.0;
    ki = 0.0;
    kd = 0.0;

  }

  public Elevator(int liftMotorPort, int switchBotPort, int switchTopPort, double kp, double ki, double kd) {
    liftMotor1 = new VictorSP(liftMotorPort);
    liftMotor2=new VictorSP(liftMotorPort);
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
  public void liftStickControl(Joystick stick)
  {
    if(stick.getRawAxis(1) < -0.5)
    {
      liftMotor1.set(-speed);
      liftMotor2.set(-speed);
    }
    else if(stick.getRawAxis(1)>0.5)
    {
      liftMotor1.set(speed);
      liftMotor2.set(speed);
    }
    else
      {
        liftMotor1.set(0);
        liftMotor2.set(0);
      }

  }
  public void liftPOVControl(double POV)
  {
      if(POV>270 || (POV<90&&POV>=0))
      {
          liftMotor1.set(-.25);
          liftMotor2.set(-.25);
      }
      else if(POV>90&&POV<270)
      {
          liftMotor1.set(.25);
          liftMotor2.set(.25);
      }
      else if(POV==-1)
        {
          liftMotor1.set(0);
          liftMotor2.set(0);
        }
  }

  public void holdPossition(boolean hold)
  {
    liftMotor2.set(-.1);
    liftMotor1.set(-.1);
  }
  public void setSetpoint(int namedPos) {
    if (namedPos >= 0 && namedPos < setpoints.length) {
      setSetpoint(setpoints[namedPos]);
    }else {
      System.err.println("Error: Setpoint accessing a value outside of the setpoints array index " +
                         "range. Not updating setpoint.");
    }
  }
  public void setSpeed(double left,double right)
  {
    liftMotor1.set(left);
    liftMotor2.set(right);
  }
}
