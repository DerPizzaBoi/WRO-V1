package main.shit;

import main.driving.LineDriveTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApplication {

    public static Logger LOGGER = LoggerFactory.getLogger("MainApplication");

    public MainApplication() {
        new LineDriveTest();
    }

    public static void main(String[] args) {
        LOGGER.warn("Hhhhhhhhhhaaaaaaaaaaaaaaaaaallllllllllllllllooooooooooooo");
        LOGGER.warn("Hhhhhhhhhhaaaaaaaaaaaaaaaaaallllllllllllllllooooooooooooo");
        LOGGER.warn("Hhhhhhhhhhaaaaaaaaaaaaaaaaaallllllllllllllllooooooooooooo");
        LOGGER.warn("Hhhhhhhhhhaaaaaaaaaaaaaaaaaallllllllllllllllooooooooooooo");
        LOGGER.warn("Hhhhhhhhhhaaaaaaaaaaaaaaaaaallllllllllllllllooooooooooooo");
        LOGGER.warn("Hhhhhhhhhhaaaaaaaaaaaaaaaaaallllllllllllllllooooooooooooo");
        new MainApplication();
    }
}