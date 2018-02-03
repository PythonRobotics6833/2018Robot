package org.usfirst.frc.team6833.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain {
    private DifferentialDrive myDrive;
    // this is the controller values for the pwm
    private double left_c;
    private double right_c;
    //this is the speedLimiter variable.
    private double v_speedLimiter;
    private int speedLimiterAxis;
    //sets up the Joystick.
    public Joystick stick;

    //standard constructor
    public Drivetrain(Talon left, Talon right)
    {

    }
    public Drivetrain(int leftTalonPort, int rightTalonPort, int speedLimiterAxis,Joystick stick)
    {
        this.stick= stick;
        //usually 3
        this.speedLimiterAxis=speedLimiterAxis;
        //left input is usually 1
        Talon m1_left = new Talon(leftTalonPort);
        SpeedControllerGroup m_left = new SpeedControllerGroup(m1_left);

        //right input is usually 0
        Talon m0_Right = new Talon(rightTalonPort);
        SpeedControllerGroup m_right = new SpeedControllerGroup(m0_Right);

        myDrive= new DifferentialDrive(m_left, m_right);
    }
    public void drive()
    {
        v_speedLimiter= stick.getRawAxis(speedLimiterAxis);
        left_c = -stick.getRawAxis(1)/(2-v_speedLimiter);
        right_c = stick.getRawAxis(5)/(2-v_speedLimiter);
        myDrive.tankDrive(left_c, right_c);
    }
    public void drive(double left, double right)
    {
        myDrive.tankDrive(left,right);
    }

}
