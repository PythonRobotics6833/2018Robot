package org.usfirst.frc.team6833.robot;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain {
    private DifferentialDrive myDrive;

    public Drivetrain(Talon left, Talon right) {

    }
    public Drivetrain(int left_input, int right_input, double left_c, double right_c){
        //left input is usually 1
        Talon m1_left = new Talon(left_input);
        SpeedControllerGroup m_left = new SpeedControllerGroup(m1_left);

        //right input is usually 0
        Talon m0_Right = new Talon(right_input);
        SpeedControllerGroup m_right = new SpeedControllerGroup(m0_Right);
        
        myDrive= new DifferentialDrive(m_left, m_right);
    }

}
