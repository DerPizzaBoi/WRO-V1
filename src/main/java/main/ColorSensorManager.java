package main;

import ev3dev.sensors.ev3.EV3ColorSensor;
import ev3dev.sensors.ev3.EV3GyroSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColorSensorManager implements Runnable{

    public static Logger LOGGER = LoggerFactory.getLogger("hurensohnnnn lgger");

    private static boolean isInUse;

    private final EV3ColorSensor lineDrive = new EV3ColorSensor(SensorPort.S3);
    private final EV3ColorSensor lineDetect = new EV3ColorSensor(SensorPort.S2);
    private final EV3ColorSensor sideScanner = new EV3ColorSensor(SensorPort.S1);
    private final EV3ColorSensor frontScanner = new EV3ColorSensor(SensorPort.S4);

    public ColorSensorManager(){
        SampleProvider sampleProvider = sideScanner.getRedMode();
        int sampleSize = sampleProvider.sampleSize();
        float[] sample = new float[sampleSize];
        for (int i = 0; i < 200; i++) {
            Delay.msDelay(200);
            sampleProvider.fetchSample(sample, 0);
            System.out.println(sample[0]);
            LOGGER.warn(sample[0] + "");
        }
    }

    @Override
    public void run() {
        new ColorSensorManager();
        isInUse = true;
    }

}