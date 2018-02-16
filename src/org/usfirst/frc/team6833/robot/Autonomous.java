package org.usfirst.frc.team6833.robot;

public class Autonomous {

    Drivetrain drive;
    int StartingPoint;
    double turnL;
    double turnR;

    private boolean right;
    private boolean left;
    private boolean foward;
    private boolean backward;

    public Autonomous(Drivetrain drive)
    {
        this.drive=drive;

    }
    public Autonomous(Drivetrain drive, int StartingPoint)
    {
        this.drive=drive;
        this.StartingPoint=StartingPoint;

    }
    public void drive()
    {
        turnL=drive.getEncoderLeftV();
        turnR=drive.getEncoderRightV();

        if(turnL>0&&turnR<0)
        {
            right=true;
            left=false;
            foward=false;
            backward=false;
        }
        else if(turnL<0&&turnR>0)
        {
            left=true;
            right=false;
            foward=false;
            backward=false;
        }
        else if(turnL>0&&turnR>0)
        {
            left=false;
            right=false;
            foward=true;
            backward=false;
        }
        else
            {
                left=false;
                right=false;
                foward=false;
                backward=true;
            }
    }


}
