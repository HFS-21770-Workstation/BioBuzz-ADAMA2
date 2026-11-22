
package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.RobotSystems.Intake;
import org.firstinspires.ftc.teamcode.RobotSystems.Shooter;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp")
public class TeleOp extends OpMode {

    Intake intake;
    Shooter shooter;

    boolean isIntake = false;
    boolean isShoot = false;
    boolean isHovala = false;
    boolean isStoop = false;

    @Override
    public void init() {

        intake = new Intake(hardwareMap);
        shooter = new Shooter(hardwareMap);

    }

    @Override
    public void loop() {

        // A - Intake ON / OFF
        if (gamepad1.aWasPressed()) {

            if (!isIntake) {
                intake.startIntake();
            } else {
                intake.stopIntake();
            }

            isIntake = !isIntake;
        }

        // X - Stopper DOWN / UP
        if (gamepad1.xWasPressed()) {

            if (!isStoop) {
                intake.stopperDown();
            } else {
                intake.stopperUp();
            }

            isStoop = !isStoop;
        }

        // B - Hovala ON / OFF
        if (gamepad1.bWasPressed()) {

            if (!isHovala) {
                intake.hovalaOn();
            } else {
                intake.hovalaOff();
            }

            isHovala = !isHovala;
        }

        // Y - Shooter ON / OFF
        if (gamepad1.yWasPressed()) {

            if (!isShoot) {
                shooter.startShootLeft(0.4);
                shooter.startShootRight(0.4);
            } else {
                shooter.startShootLeft(0);
                shooter.startShootRight(0);

            }

            isShoot = !isShoot;
        }
    }
}
