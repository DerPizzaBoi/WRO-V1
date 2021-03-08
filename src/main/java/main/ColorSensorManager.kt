package main

import ev3dev.sensors.ev3.EV3ColorSensor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import lejos.hardware.port.SensorPort
import lejos.utility.Delay
import org.slf4j.LoggerFactory
import java.awt.Color

class ColorSensorManager : Runnable {

    private val scope = CoroutineScope(Dispatchers.Unconfined)
    private val logger = LoggerFactory.getLogger("joe")
    private var abchecking= true

    private val lineDrive = EV3ColorSensor(SensorPort.S3);
    private val lineDetect = EV3ColorSensor(SensorPort.S2);
    private val sideScanner = EV3ColorSensor(SensorPort.S1);
    private val frontScanner = EV3ColorSensor(SensorPort.S4);

    private val colorManagerEventChannel = Channel<ColorSensorEvent>(Channel.CONFLATED)
    val colorManagerEvent = colorManagerEventChannel.receiveAsFlow()

    private fun _init() {
        logger.warn("_init")
        var sampleProvider = sideScanner.redMode
        var sampleSize = sampleProvider.sampleSize()
        var sample = FloatArray(sampleSize)
        for (i in 1..200) {
            Delay.msDelay(500)
            sampleProvider.fetchSample(sample, 0)
            //logger.info(sample[0].toString())
            if (sample[0] == BLUE) {
                notifyData(sample[0])
            }
        }
    }

    init {
        logger.warn("init")
    }

    private fun notifyData(color: Float) = scope.launch {
        colorManagerEventChannel.send(ColorSensorEvent.ColorEvent(color))
    }

    sealed class ColorSensorEvent {
        data class ColorEvent(val color: Float) : ColorSensorEvent()
    }

     private fun colorrange(){
         var sampleProvider = sideScanner.redMode
         var sampleSize = sampleProvider.sampleSize()
         var sample = FloatArray(sampleSize)
    while (abchecking){
        var v =sideScanner.ambientMode
        var p = v/ 80
    }

    }

    override fun run() {
        _init()
    }
}