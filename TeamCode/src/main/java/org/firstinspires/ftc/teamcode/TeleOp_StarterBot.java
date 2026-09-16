package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class TeleOp_StarterBot extends OpMode {

    DriveTrain driveTrain = new DriveTrain();

    @Override
    public void init() {
        driveTrain.init(hardwareMap);
        driveTrain.setDriveSpeed(1);
    }

    @Override
    public void loop() {
        driveTrain.gamepadDrive(gamepad1);

    }
}
