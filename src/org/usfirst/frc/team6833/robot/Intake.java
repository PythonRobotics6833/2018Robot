package org.usfirst.frc.team6833.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Victor;

public class Intake {
  // Motor directions are based on robot orientation.
  private VictorSP left;
  private VictorSP right;

  // Independent motor speeds
  private double leftSpeed;
  private double rightSpeed;

  // Toggles for inverting motor directions independently
  private boolean leftInverted;
  private boolean rightInverted;


  /*public Intake(Talon left, Talon right) {

    this.left = left;
    this.right = right;

    leftSpeed = 0.5;
    rightSpeed = 0.5;

    leftInverted = false;
    rightInverted = false;
  }

  public Intake(Talon left, Talon right, boolean leftInverted, boolean rightInverted) {
    this.left = left;
    this.right = right;

    leftSpeed = 0.5;
    rightSpeed = 0.5;

    this.leftInverted = leftInverted;
    this.rightInverted = rightInverted;
  }

  public Intake(int leftPort, int rightPort) {
    left = new Talon(leftPort);
    right = new Talon(rightPort);

    leftSpeed = 0.5;
    rightSpeed = 0.5;

    this.leftInverted = false;
    this.rightInverted = false;
  }*/
  public Intake(int leftPortSPX, int rightPortSPX,boolean leftInverted, boolean rightInverted) {
    left = new VictorSP(leftPortSPX);
    right = new VictorSP(rightPortSPX);

    leftSpeed = 0.5;
    rightSpeed = 0.5;

    this.leftInverted = leftInverted;
    this.rightInverted = rightInverted;
  }

  /*public Intake(int leftPort, int rightPort, boolean leftInverted, boolean rightInverted) {
    left = new Talon(leftPort);
    right = new Talon(rightPort);

    leftSpeed = 0.5;
    rightSpeed = 0.5;

    this.leftInverted = leftInverted;
    this.rightInverted = rightInverted;
  }*/

  public void intake(boolean intake, boolean outtake) {
    if (intake)
    {
      if (leftInverted)
      {
        left.set(leftSpeed);
      }
      else
        {
        left.set(-leftSpeed);
        }

      if (rightInverted)
      {
        right.set(rightSpeed);
      }
      else
        {
        right.set(-rightSpeed);
        }
    }
    else if (outtake)
    {
      if (leftInverted)
      {
        left.set(-leftSpeed);
      }
      else
        {
        left.set(leftSpeed);
        }

      if (rightInverted)
      {
        right.set(-rightSpeed);
      }
      else
        {
        right.set(rightSpeed);
        }
    }
    else
      {
      left.set(0.0);
      right.set(0.0);
      }
  }
  public void intake(double leftSpeed, double rightSpeed)
  {
    //left.setSpeed(leftSpeed);
    //right.setSpeed(rightSpeed);

    left.set(leftSpeed);
    right.set(rightSpeed);

  }
  public void intake(double liftController)
  {
    double inputSqd=(liftController*liftController);
    if(liftController<0)
    {
      left.set(leftSpeed*inputSqd);
      right.set(rightSpeed*inputSqd);
    }
    else if (liftController>0)
    {
      left.set(leftSpeed*inputSqd);
      left.set(rightSpeed*inputSqd);
    }
    else
    {
      left.set(0.0);
      right.set(0.0);
    }
  }
}
