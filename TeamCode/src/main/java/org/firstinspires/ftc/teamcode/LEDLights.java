package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;

public class LEDLights {

    private LED redLight;
    private LED greenLight;

    public void init(HardwareMap hwmap){
        redLight = hwmap.get(LED.class, "led_red");
        greenLight = hwmap.get(LED.class, "led_green");
    }

    public void setRedLed(boolean isOn){
        if (isOn){
            redLight.on();
        }
        else{
            redLight.off();
        }
    }

    public void setGreenLed(boolean isOn){
        if (isOn){
            greenLight.on();
        }
        else{
            greenLight.off();
        }
    }

}
