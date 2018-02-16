package org.usfirst.frc.team6833.robot;

public class Autonomous {

    Drivetrain drive;
    int StartingPoint;
    public Autonomous(Drivetrain drive)
    {
        this.drive=drive;

    }
    public Autonomous(Drivetrain drive, int StartingPoint)
    {
        this.drive=drive;
        this.StartingPoint=StartingPoint;

    }


}
