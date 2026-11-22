//
//package org.firstinspires.ftc.teamcode.OpModes;
//
//import com.acmerobotics.dashboard.FtcDashboard;
//import com.acmerobotics.dashboard.config.Config;
//import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//
//import org.firstinspires.ftc.teamcode.RobotSystems.Shooter;
//
//@Config
//@TeleOp(name = "Shooter Dashboard Tuning")
//public class pidf extends OpMode {
//
//    Shooter shooter;
//
//    // Dashboard controls
//    public static double targetRPM = 3000;
//
//    public static double kP = 0.0024;
//    public static double kI = 0;
//    public static double kD = 0;
//
//    public static double kFLeft = 0.000206;
//    public static double kFRight = 0.000206;
//
//    public static boolean shooterEnabled = true;
//
//    @Override
//    public void init() {
//        shooter = new Shooter(hardwareMap);
//
//        telemetry = new MultipleTelemetry(
//                telemetry,
//                FtcDashboard.getInstance().getTelemetry()
//        );
//    }
//
//    @Override
//    public void loop() {
//
//        if (shooterEnabled) {
//
//            shooter.setVelocityLeft(targetRPM, kP, kI, kD, kFLeft);
//
//            shooter.setVelocityRight(
//                    targetRPM, kP, kI, kD, kFRight
//            );
//
//        } else {
//            shooter.stopShooter();
//        }
//
//        telemetry.addData("Target RPM", targetRPM);
//
//        telemetry.addData("Left RPM", shooter.getVelocityLeft());
//        telemetry.addData("Right RPM", shooter.getVelocityRight());
//
//        telemetry.addData("Left Error",
//                targetRPM - shooter.getVelocityLeft());
//
//        telemetry.addData("Right Error",
//                targetRPM - shooter.getVelocityRight());
//
//        telemetry.addData("Left Power", shooter.getPowerLeft());
//        telemetry.addData("Right Power", shooter.getPowerRight());
//
//        telemetry.update();
//    }
//
//    @Override
//    public void stop() {
//        shooter.stopShooter();
//    }
//}
