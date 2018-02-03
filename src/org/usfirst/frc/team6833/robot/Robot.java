package org.usfirst.frc.team6833.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.*;



import edu.wpi.first.wpilibj.Timer;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;


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
	//yes this is a test
	
	//set up the DifferentalDrive because apparently RobotDrive was too complicated
	DifferentialDrive myDrive;
	
	//Everything else
	Timer timer;
	Joystick stick;
	Joystick liftController;
	Intake intake;

	double leftt;
	double rightt;
	double v_speedLimiter;
	
	public void robotInit() 
	{
		stick = new Joystick(0);
		liftController= new Joystick(1);
		
		timer= new Timer();
		
		//set up the drive train
		Talon m1_left = new Talon(1);
		
		SpeedControllerGroup m_left = new SpeedControllerGroup(m1_left);

		Talon m0_Right = new Talon(0);
		SpeedControllerGroup m_right = new SpeedControllerGroup(m0_Right);
		myDrive= new DifferentialDrive(m_left, m_right);
		
		//Set up the lift
		Talon m2_left= new Talon(2);
		Talon m3_Right= new Talon(3);
		intake= new Intake(m2_left,m3_Right);
		
		//camera code 
          //new Thread(() -> {
        	   
        	   CameraServer server = CameraServer.getInstance();
        	
        	   server.startAutomaticCapture("cam0", 0);
                /*((UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
                camera.setResolution(1920, 1080);
                
                CvSink cvSink = CameraServer.getInstance().getVideo();
                CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
                
                Mat source = new Mat();
                Mat output = new Mat();
                
                while(!Thread.interrupted()) 
                {
                    cvSink.grabFrame(source);
                    Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                    outputStream.putFrame(output);
                }*/
            //}).start();
	}
	
	
	public void autonomousInit() 
	{
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	
	
	public void autonomousPeriodic() 
	{
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	
	public void teleopPeriodic() 
	{
		v_speedLimiter= stick.getRawAxis(2);
		leftt = -stick.getRawAxis(1)/(2-v_speedLimiter);
		rightt = -stick.getRawAxis(5)/(2-v_speedLimiter);
			
		myDrive.tankDrive(leftt, rightt);
		boolean EB= stick.getRawButton(8);
		
		//operatorControl();
		if(!EB) 
		{	
			myDrive.tankDrive(leftt, rightt);
		}
				
		if(EB) 
		{
			myDrive.tankDrive(0, 0);
		}
			
		
	}


}	
						


	
	
	
	

