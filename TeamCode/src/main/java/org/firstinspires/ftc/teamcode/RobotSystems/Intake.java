package org.firstinspires.ftc.teamcode.RobotSystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    DcMotor intakeMotor;
    CRServo hovala;
    Servo stopper;

    public Intake(HardwareMap hardwareMap){
        intakeMotor = hardwareMap.dcMotor.get("IntakeMotor");
        hovala = hardwareMap.crservo.get("hovala");
        stopper = hardwareMap.servo.get("stopper");
        hovala.setDirection(DcMotorSimple.Direction.REVERSE);
        stopper.setPosition(0);
    }
    public void startIntake(){
      intakeMotor.setPower(0.6);
    }

    public void stopIntake(){
        intakeMotor.setPower(0);
    }
    public void reversIntake(){
        intakeMotor.setPower(-1);
    }

    public void stopperUp(){
        stopper.setPosition(0.6);
    }

    public void stopperDown(){
        stopper.setPosition(0);
    }

    public void hovalaOn(){
        hovala.setPower(1);
    }
    public void hovalaOff(){
        hovala.setPower(0);
    }



}
