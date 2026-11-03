package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class TeleOp_StarterBot extends OpMode {
    DriveTrain driveTrain = new DriveTrain();
    DcMotorEx shooter;
    DcMotor intake;
    CRServo flipper;
    CRServo rightIntakeWheel;
    CRServo leftIntakeWheel;

    LEDLights light = new LEDLights();

    double velocity;

    @Override
    public void init() {
        driveTrain.init(hardwareMap);
        driveTrain.setDriveSpeed(1);

        shooter = hardwareMap.get(DcMotorEx.class,"shooter");
        intake = hardwareMap.get(DcMotor.class,"intake");
        flipper = hardwareMap.get(CRServo.class,"flipper");
        rightIntakeWheel = hardwareMap.get(CRServo.class,"rightIntakeWheel");
        leftIntakeWheel = hardwareMap.get(CRServo.class,"leftIntakeWheel");

        velocity = 1350;

        shooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
        driveTrain.gamepadDrive(gamepad1);

        if(gamepad2.dpadLeftWasPressed()){
            intake.setPower(1);
            rightIntakeWheel.setPower(1);
            leftIntakeWheel.setPower(-1);
        } else if (gamepad2.dpadLeftWasReleased()) {
            intake.setPower(0);
            rightIntakeWheel.setPower(0);
            leftIntakeWheel.setPower(0);
        }
        if (gamepad2.dpadDownWasPressed()) {
            intake.setPower(-1);
            rightIntakeWheel.setPower(-1);
            leftIntakeWheel.setPower(1);
        }

        if(gamepad2.dpad_right){
            shooter.setVelocity(0);
        }

        if(gamepad2.x) {
            shooter.setVelocity(velocity);
        }

        if(gamepad2.bWasPressed()) {
            flipper.setPower(1);
        } else if (gamepad2.bWasReleased()){
            flipper.setPower(0);
        }

        if(shooter.getVelocity() > velocity - 50 && shooter.getVelocity() < velocity + 50){
            light.setRedLed(true);
            light.setGreenLed(false);
        } else if (shooter.getVelocity() > velocity - 150 && shooter.getVelocity() < velocity - 50 || shooter.getVelocity() < velocity + 150 && shooter.getVelocity() > velocity + 50) {
            light.setRedLed(true);
            light.setGreenLed(true);
        }else {
            light.setRedLed(false);
            light.setGreenLed(true);
        }
        telemetry.addData("Target Velocity", velocity);
        telemetry.addData("Current Velocity",shooter.getVelocity());

    }
}
