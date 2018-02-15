package org.usfirst.frc.team6833.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


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

    WPI_TalonSRX m1_left;
    WPI_TalonSRX m1_Right;


    //standard constructor
    public Drivetrain(Talon left, Talon right)
    {
        TalonSRX exampleTalonSRX = new TalonSRX(2);

    }
    //pratice robot
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
    //main robot constructer
    public Drivetrain(int leftTalonSRXPort1, int rightTalonSRXPort1,int leftTalonSRXPort2, int rightTalonSRXPort2, int speedLimiterAxis, Joystick stick)
    {
        this.stick= stick;
        //usually 3
        this.speedLimiterAxis=speedLimiterAxis;
        //These are the masters.
        m1_left = new WPI_TalonSRX(leftTalonSRXPort1);
        m1_Right = new WPI_TalonSRX(rightTalonSRXPort1);

        //these are slaves
        WPI_TalonSRX m2_left = new WPI_TalonSRX(leftTalonSRXPort2);
        WPI_TalonSRX m2_Right= new WPI_TalonSRX(rightTalonSRXPort2);

        myDrive= new DifferentialDrive(m1_left, m1_Right);

        //make the slaves follow the master
        m2_left.follow(m1_left);
        m2_Right.follow(m1_Right);

        m1_left.setInverted(false);
        m2_left.setInverted(false);
        m1_Right.setInverted(true);
        m2_Right.setInverted(true);

        //make the
        m1_left.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);
        m1_Right.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);

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

    public double getEncoderLeftV()
    {
        return m1_left.getSelectedSensorVelocity(0);
    }

    public double getEncoderRightV()
    {
        return m1_Right.getSelectedSensorVelocity(0);
    }

    public double getEncoderLeftP()
    {
        return m1_left.getSelectedSensorPosition(0);
    }

    public double getEncoderRightP()
    {
        return m1_Right.getSelectedSensorPosition(0);
    }

}
