
package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.MecanumDrive;
@Config
@TeleOp(name = "ball")
public class ball extends OpMode {

    MecanumDrive mecanumDrive;
    GoBildaPinpointDriver pinpoint;

    @Override
    public void init() {
        mecanumDrive = new MecanumDrive(
                hardwareMap,
                new Pose2d(0, 0, Math.toRadians(90))
        );

        pinpoint = hardwareMap.get(
                GoBildaPinpointDriver.class,
                "pinpoint"
        );
        telemetry = new MultipleTelemetry(
                telemetry,
                FtcDashboard.getInstance().getTelemetry()
        );
    }


    @Override
    public void loop() {

        double x = -gamepad1.left_stick_y;
        double y = -gamepad1.right_stick_x;
        double rx = -gamepad1.left_stick_x;

        mecanumDrive.setDrivePowers(
                new PoseVelocity2d(
                        new Vector2d(x, y),
                        rx
                )
        );

        pinpoint.update();

        telemetry.addData("Pinpoint X", pinpoint.getPosX(DistanceUnit.INCH));
        telemetry.addData("Pinpoint Y", pinpoint.getPosY(DistanceUnit.INCH));
        telemetry.addData("Velocity X", pinpoint.getVelX(DistanceUnit.INCH));
        telemetry.addData("Velocity Y", pinpoint.getVelY(DistanceUnit.INCH));
        telemetry.addData("Heading", pinpoint.getHeading(
                org.firstinspires.ftc.robotcore.external.navigation.UnnormalizedAngleUnit.RADIANS
        ));
        telemetry.update();
    }
}
