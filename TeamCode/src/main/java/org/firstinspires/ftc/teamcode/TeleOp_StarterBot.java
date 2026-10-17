package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

public class TeleOp_StarterBot extends OpMode {
    DriveTrain driveTrain = new DriveTrain();
    DcMotor shooter;
    DcMotor intake;
    CRServo flipper;
    CRServo rightIntakeWheel;
    CRServo leftIntakeWheel;

    @Override
    public void init() {
        driveTrain.init(hardwareMap);
        driveTrain.setDriveSpeed(1);

        shooter = hardwareMap.get(DcMotor.class,"shooter");
        intake = hardwareMap.get(DcMotor.class,"intake");
        flipper = hardwareMap.get(CRServo.class,"flipper");
        rightIntakeWheel = hardwareMap.get(CRServo.class,"rightIntakeWheel");
        leftIntakeWheel = hardwareMap.get(CRServo.class,"leftIntakeWheel");
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
        if(gamepad2.dpad_right){
            shooter.setPower(0);
        }
        if(gamepad2.x) {
            shooter.setPower(0.75);
        }
        if(gamepad2.bWasPressed()) {

            flipper.setPower(1);
        } else if (gamepad2.bWasReleased()){
            flipper.setPower(0);
        }

    }
}
