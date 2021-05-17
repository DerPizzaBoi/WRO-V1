package main.driving

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor
import ev3dev.sensors.ev3.EV3ColorSensor
import lejos.hardware.port.MotorPort
import lejos.hardware.port.SensorPort
import lejos.robotics.filter.SampleThread

class LineDriveTest {

    @Volatile
    private var isRunning = false

    private val colorSensor = EV3ColorSensor(SensorPort.S1)
    private val leftMotor = EV3LargeRegulatedMotor(MotorPort.A)
    private val rightMotor = EV3LargeRegulatedMotor(MotorPort.B)

    init {
        var sample : FloatArray

        colorSensor.redMode

        var i = 0

        while (isRunning) {
            sample = FloatArray(colorSensor.sampleSize())

            colorSensor.fetchSample(sample, 0)
            println("sample size ${sample.size}")
            println("0 ${sample[0]}")
            println("1 ${sample[1]}")
            println("3 ${sample[2]}")

            Thread.sleep(2000)
            i++
            if(i > 10) {
                isRunning = !isRunning
            }
        }

    }

}