package org.usfirst.frc.team6833.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.*;



import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;


import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
//@SuppressWarnings("deprecation")
public class Robot extends IterativeRobot 
{	
	//Serial port set up
	Command autoMode;
	SendableChooser autoChooser;

	Ultrasonic sonic1;
	Ultrasonic sonic2;
	Ultrasonic sonic3;
	Ultrasonic sonic4;
	//set up the the drivetrain
	Drivetrain myDrive;
	Autonomous auto;
	Intake intake;
	Elevator el;

	//Everything else
	Timer timer;
	Joystick stick;
	Joystick liftController;
	boolean yes=false;
	public void robotInit() 
	{
		sonic1= new Ultrasonic(0,1);
		sonic2=new Ultrasonic(2,3);
		sonic3= new Ultrasonic(4,5);
		sonic4=new Ultrasonic(6,7);

		stick = new Joystick(0);
		//liftController= new Joystick(1);

		//Setting up drive train
		//the one below is for practice robot
		//myDrive= new Drivetrain(1,0,3,stick);

		//The drivetrain below is for the main robot
		myDrive=new Drivetrain(3,1,2,4,3,stick);

		auto=new Autonomous(myDrive,0);
		//Set up the intake
		intake= new Intake(0,1, false,true);
		el=new Elevator(2,3);

		sonic1.setAutomaticMode(true);
		sonic2.setAutomaticMode(true);
		sonic3.setAutomaticMode(true);
		sonic4.setAutomaticMode(true);
		//camera code 
          //new Thread(() -> {
		CameraServer server = CameraServer.getInstance();
		server.startAutomaticCapture("cam0", 0);

            //}).start();
		//setting up dashboard to chose auto position
		//autoChooser=new SendableChooser();
		//autoChooser.addDefault("Center and on left side", );
		//autoChooser.addObject("Top and on the left side", );
	}
	
	
	public void autonomousInit() 
	{

	    yes=false;
	}

	/**
	 * This function is called periodically during autonomous
	 */
	
	
	public void autonomousPeriodic() 
	{
		if(yes==false)
		{

			//this works so use this for reference.
			//auto.moveFoward(18.85, myDrive.getEncoderLeftP(), myDrive.getEncoderRightP());
           	auto.turn(1,true,myDrive.getEncoderLeftP(),myDrive.getEncoderRightP());
           	auto.moveForward(80,myDrive.getEncoderLeftP(),myDrive.getEncoderRightP());
            System.err.println(myDrive.getEncoderLeftP());
			yes=true;

		}
		else
		    {
		        myDrive.drive(0.0,0.0);
            }
	}

	/**
	 * This function is called periodically during operator control
	 */
	
	public void teleopPeriodic() 
	{
		double inch1=sonic1.getRangeInches();
		double inch2=sonic2.getRangeInches();
		double inch3=sonic3.getRangeInches();
		double inch4=sonic4.getRangeInches();
		boolean EB= stick.getRawButton(8);
		//double Intake_input= liftController.getRawAxis(3);

		//if the emergency break is not active
		if(!EB) 
		{
            myDrive.drive();
			intake.intake(stick.getRawButton(5),stick.getRawButton(6));
			System.err.println(stick.getPOV());
		}
		//When the emergency break is active
		else
		{
            myDrive.drive(0.0,0.0);
		}
		//System.err.println("inches 1 "+inch1+"inches 2 "+inch2+"inches 3 "+inch3+"inches 4 "+inch4);
		//System.err.println(myDrive.getEncoderLeftV());

		
	}


}