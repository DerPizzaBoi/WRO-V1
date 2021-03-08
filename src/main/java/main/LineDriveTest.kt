package main

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor
import ev3dev.sensors.ev3.EV3ColorSensor
import lejos.hardware.port.MotorPort
import lejos.hardware.port.SensorPort
import lejos.utility.Delay
import main.values.Speed

class LineDriveTest private constructor() : Runnable {

    private enum class DIRECTION { LEFT, RIGHT }
    private val currentDirection = DIRECTION.RIGHT

    val isUsed = false

    private val motorL = EV3LargeRegulatedMotor(MotorPort.A)
    private val motorR = EV3LargeRegulatedMotor(MotorPort.B)
    private val colorSensor = EV3ColorSensor(SensorPort.S1)

    fun driveToLine() {
        motorL.speed = Speed.fast
        motorR.speed = Speed.fast + 10
        motorL.forward()
        motorR.forward()
        Delay.msDelay(200)
    }

    private fun _init() {
        while (isUsed) {


            if(DIRECTION.LEFT){

            }
        }
    }

    companion object {
        val instance = LineDriveTest()
    }

    override fun run() {
        driveToLine()
        _init()
    }
}