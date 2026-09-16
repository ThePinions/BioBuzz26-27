package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {
    DcMotor fL;
    DcMotor bL;
    DcMotor fR;
    DcMotor bR;
    double driveSpeed = 1;

    public void init(HardwareMap hwMap) {
        fL = hwMap.get(DcMotor.class, "frontLeft");
        bL = hwMap.get(DcMotor.class, "backLeft");
        fR = hwMap.get(DcMotor.class, "frontRight");
        bR = hwMap.get(DcMotor.class, "backRight");

        fL.setDirection(DcMotorSimple.Direction.REVERSE);
        bL.setDirection(DcMotorSimple.Direction.REVERSE);

        fL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setDriveSpeed(double speed){
        driveSpeed = speed;
    }

    public void gamepadDrive(Gamepad driveController){
        double y = -driveController.left_stick_y;
        double x = driveController.left_stick_x;
        double rx = driveController.right_stick_x;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = ((y + x + rx) / denominator * driveSpeed);
        double backLeftPower = ((y - x + rx) / denominator * driveSpeed);
        double frontRightPower = ((y - x - rx) / denominator * driveSpeed);
        double backRightPower = ((y + x - rx) / denominator * driveSpeed);

        fL.setPower(frontLeftPower);
        bL.setPower(backLeftPower);
        fR.setPower(frontRightPower);
        bR.setPower(backRightPower);
    }

}
