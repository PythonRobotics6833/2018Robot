package org.usfirst.frc.team6833.robot;
import edu.wpi.first.wpilibj.Timer;

public class Autonomous {

    Drivetrain drive;
    Timer timer;
    int StartingPoint;
    double turnL;
    double turnR;
    int currentx;
    int currenty;

    private boolean right;
    private boolean left;
    private boolean foward;
    private boolean backward;
    public double angle = 90;

    //all x lines in field
    private int fieldx1[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx2[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx3[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx4[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx5[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx6[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx7[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx8[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx9[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx10[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx11[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx12[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx13[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx14[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx15[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx16[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx17[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int fieldx18[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

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
        //find the delta of one
        int deltaX=positionx-currentx;
        int deltaY=positiony-currenty;

        if(deltaX<0 && this.angle != 270)
        {
            if (this.angle > 270)
            {
                turn(1,true, drive.getEncoderLeftP(),drive.getEncoderLeftP());
            }
            else
                {
                    turn(((270-this.angle)/90),false, drive.getEncoderLeftP(),drive.getEncoderLeftP());
                }
        }
        //set up
        if(deltaX>0&& this.angle !=90)
        {
            if (this.angle > 180)
            {
                turn(((this.angle-90)/90),true, drive.getEncoderLeftP(),drive.getEncoderLeftP());
            }
            else
            {
                turn( ((90-this.angle)/90),false, drive.getEncoderLeftP(),drive.getEncoderLeftP());
            }
        }
        //drive on the x axis
        if((deltaX>0 && this.angle==90) || (deltaX<0 && this.angle ==270))
        {

            moveFoward(deltaX*18,drive.getEncoderLeftP(),drive.getEncoderRightP());
            deltaX=0;
        }

        //check to see if we can start moving in the y direction
        if(deltaX==0)
        {
            //if we have to move in the - y direction
            if(deltaY<0 && this.angle != 0)
            {
                if (this.angle > 0 && this.angle<=180)
                {
                    turn((this.angle/90),true, drive.getEncoderLeftP(),drive.getEncoderLeftP());
                }
                else if(this.angle> 180)
                {
                    turn(((360-this.angle)/90),false, drive.getEncoderLeftP(),drive.getEncoderLeftP());
                }
            }
            //if we have to go in the + y direction
            if(deltaY>0&& this.angle !=180)
            {
                if (this.angle > 180)
                {
                    turn(((this.angle-180)/90),true, drive.getEncoderLeftP(),drive.getEncoderLeftP());
                }
                else
                {
                    turn( ((180-this.angle)/90),false, drive.getEncoderLeftP(),drive.getEncoderLeftP());
                }
            }
            //drive on the y axis
            if((deltaY>0 && this.angle==180) || (deltaY<0 && this.angle ==270))
            {

                moveFoward(deltaY*18,drive.getEncoderLeftP(),drive.getEncoderRightP());
                deltaY=0;
            }
        }


    }
    public void turn(double angle,boolean turnl, double positionL, double positionR)
    {
        ///angle is how many 90 degree
        if(turnl==true)
        {
            while((drive.getEncoderRightP()-positionR)<((19.125*1024)*angle) )
            {
                drive.drive(-1,-1);
            }

            this.angle= this.angle+angle;
            if (this.angle<0)
            {
                    this.angle=360-angle;
            }
            return;

        }
        else if(turnl==false)
        {
            while((drive.getEncoderLeftP()-positionL)<((19.125*1024)*angle))
            {
                drive.drive(1,1);
            }
            this.angle= this.angle+angle;
            if (this.angle>360)
            {
                this.angle=angle-360;
            }
            return;
        }
        if((drive.getEncoderLeftP()-positionL)<0.1&& (drive.getEncoderLeftP()-positionL)>-0.1)
        {
            return;
        }
    }
    public void moveFoward(double distance, double positionL, double positionR)
    {
        ///distance is in inches
        //spare code here  -((distance)*drive.getEncoderLeftV()))
        double currentPos=(drive.getEncoderLeftP()-positionL);
        double neededPos=(1024*(distance/23));

        while ((currentPos)<neededPos)
        {
            drive.drive(.5,-.45);
            timer.delay(0.005);
            currentPos=(drive.getEncoderLeftP()-positionL);
            timer.delay(0.05);
        }
        drive.drive(0,0);
        if(this.angle==0)
        {
            currenty=(currenty-Math.toIntExact(Math.round(distance/18)));
            return;
        }
        if(this.angle==90)
        {
            currentx=(currentx+Math.toIntExact(Math.round(distance/18)));
            return;
        }
        if(this.angle==180)
        {
            currenty=(currenty+Math.toIntExact(Math.round(distance/18)));
            return;
        }
        if(this.angle==270)
        {
            currentx=(currentx-Math.toIntExact(Math.round(distance/18)));
            return;
        }
    }
    public void moveBackward(double distance, double positionL, double positionR)
    {
        ///distance is in inches
            if ((drive.getEncoderLeftP()-positionL)>(2048*(distance/8)))
            {
                drive.drive(-1,1);
            }
    }


}



