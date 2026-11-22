
package org.firstinspires.ftc.teamcode.RobotSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Util.PIDFController;

public class Shooter {

    public DcMotorEx shooterMotorLeft;
    public DcMotorEx shooterMotorRight;

    private PIDFController pidfControllerLeft;
    private PIDFController pidfControllerRight;

    private static final double TICKS_PER_REVOLUTION = 28.0;

    public Shooter(HardwareMap hardwareMap) {

        shooterMotorLeft = hardwareMap.get(DcMotorEx.class, "motor 1");

        shooterMotorRight = hardwareMap.get(DcMotorEx.class, "motor 2");

        shooterMotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        shooterMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        shooterMotorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        shooterMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        shooterMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        shooterMotorLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        shooterMotorRight.setDirection(DcMotorSimple.Direction.FORWARD);

        pidfControllerLeft = new PIDFController(0, 0, 0, 0, 1, 0, false);

        pidfControllerRight = new PIDFController(0, 0, 0, 0, 1, 0, false);
    }

    public void startShootLeft(double power) {
        shooterMotorLeft.setPower(power);
    }

    public void startShootRight(double power) {
        shooterMotorRight.setPower(power);
    }

    public double getVelocityLeft() {
        return shooterMotorLeft.getVelocity()
                * 60.0 / TICKS_PER_REVOLUTION;
    }

    public double getVelocityRight() {
        return shooterMotorRight.getVelocity()
                * 60.0 / TICKS_PER_REVOLUTION;
    }

    public void setVelocityLeft(
            double velocity,
            double kp,
            double ki,
            double kd,
            double kf) {

        pidfControllerLeft.updateValues(
                kp, ki, kd, kf, 1, 0
        );

        double power = pidfControllerLeft.updateController(
                velocity, getVelocityLeft()
        );

        startShootLeft(power);
    }

    public void setVelocityRight(
            double velocity,
            double kp,
            double ki,
            double kd,
            double kf) {

        pidfControllerRight.updateValues(
                kp, ki, kd, kf, 1, 0
        );

        double power = pidfControllerRight.updateController(
                velocity, getVelocityRight()
        );

        startShootRight(power);
    }

    public double getPowerLeft() {
        return pidfControllerLeft.getOutput();
    }

    public double getPowerRight() {
        return pidfControllerRight.getOutput();
    }

    public void stopShooter() {

        shooterMotorLeft.setPower(0);
        shooterMotorRight.setPower(0);

        pidfControllerLeft.reset();
        pidfControllerRight.reset();
    }
}
