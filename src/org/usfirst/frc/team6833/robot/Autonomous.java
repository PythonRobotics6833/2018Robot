package org.usfirst.frc.team6833.robot;

public class Autonomous {

    Drivetrain drive;
    int StartingPoint;
    double turnL;
    double turnR;
    int currentx;
    int currenty;

    private boolean right;
    private boolean left;
    private boolean foward;
    private boolean backward;
    private double angle = 90;

    //all x lines in field
    int fieldx1[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx2[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx3[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx4[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx5[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx6[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx7[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx8[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx9[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx10[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx11[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx12[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx13[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx14[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx15[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx16[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx17[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int fieldx18[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    int fieldy[][] =
            {
                    fieldx1,
                    fieldx2,
                    fieldx3,
                    fieldx4,
                    fieldx5,
                    fieldx6,
                    fieldx7,
                    fieldx8,
                    fieldx9,
                    fieldx10,
                    fieldx11,
                    fieldx12,
                    fieldx13,
                    fieldx14,
                    fieldx15,
                    fieldx16,
                    fieldx17,
                    fieldx18
            };


    public Autonomous(Drivetrain drive) {
        this.drive = drive;

    }

    public Autonomous(Drivetrain drive, int StartingPoint) {
        this.drive = drive;
        this.StartingPoint = StartingPoint;

    }

    public void calculatePosition(int StartingPoint, boolean blueTeam) {
        if (blueTeam) {
            switch (StartingPoint) {
                case 0:
                    fieldy[5][35] = 2;
                    this.currentx=35;
                    this.currenty=5;
                    break;
                case 1:
                    fieldy[9][35] = 2;
                    this.currentx=35;
                    this.currenty=9;
                    break;
                case 2:
                    fieldy[14][35] = 2;
                    this.currentx=0;
                    this.currenty=14;
                    break;
            }
        } else {
            switch (StartingPoint) {
                case 0:
                    fieldy[5][0] = 2;
                    this.currentx=0;
                    this.currenty=5;
                    break;
                case 1:
                    fieldy[9][0] = 2;
                    this.currentx=0;
                    this.currenty=9;
                    break;
                case 2:
                    fieldy[14][0] = 2;
                    this.currentx=0;
                    this.currenty=14;
                    break;
            }
        }

    }

    public void driveActionCheck() {
        turnL = drive.getEncoderLeftV();
        turnR = drive.getEncoderRightV();

        if (turnL > 0 && turnR < 0) {
            right = true;
            left = false;
            foward = false;
            backward = false;
        } else if (turnL < 0 && turnR > 0) {
            left = true;
            right = false;
            foward = false;
            backward = false;
        } else if (turnL > 0 && turnR > 0) {
            left = false;
            right = false;
            foward = true;
            backward = false;
        } else {
            left = false;
            right = false;
            foward = false;
            backward = true;
        }
    }

    public void driveToWayPoint(int positionx, int positiony)
    {

    }
    public void turn(double angle, double positionL, double positionR)
    {
        if(angle== -90)
        {
            if((drive.getEncoderRightP()-positionR)<(19.125*1024) )
            {
                drive.drive(-1,1);
            }
            else
            {
                this.angle= this.angle+angle;
                if (this.angle<0)
                {
                    this.angle=360-angle;
                }
                return;
            }
        }
        else if(angle== 90)
        {
            if((drive.getEncoderLeftP()-positionL)<(19.125*1024))
            {
                drive.drive(1,-1);
            }
            else
                {
                    this.angle= this.angle+angle;
                    if (this.angle>360)
                    {
                        this.angle=angle-360;
                    }
                    return;
                }
        }
    }
    public void moveFoward(double distance, double positionL, double positionR)
    {
        ///distance is in inches
        while ((drive.getEncoderLeftP()-positionL)<(1024*(distance/8)))
        {
            drive.drive(1,1);
        }

        if(this.angle==0)
        {
            currenty=(currenty-Math.toIntExact(Math.round(distance/18)));
        }
        if(this.angle==90)
        {
            currentx=(currentx+Math.toIntExact(Math.round(distance/18)));
        }
        if(this.angle==180)
        {
            currenty=(currenty+Math.toIntExact(Math.round(distance/18)));
        }
        if(this.angle==270)
        {
            currentx=(currentx-Math.toIntExact(Math.round(distance/18)));
        }
    }
    public void moveBackward(double distance, double positionL, double positionR)
    {
        ///distance is in inches
            if ((drive.getEncoderLeftP()-positionL)>(1024*(distance/8)))
            {
                drive.drive(-1,-1);
            }
    }


}



