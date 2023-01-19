package org.example;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.example.GameInfo.*;

public class Main {

    //private static final BotStateSwitcher SWITCHER = BotStateSwitcher.createSwitcher();
    public static final Robot ROBOT = createRobot();
    @SneakyThrows
    private static Robot createRobot() {
        return new Robot();
    }

    public static void main(String[] args) throws IOException {
        gameProcessing();
        //makeScreenshot();

    }

    private static void gameProcessing() {
        long start = System.currentTimeMillis();
        long year = 31104000000L;
        while (System.currentTimeMillis() - start < year) {
            Rectangle rectangle = new Rectangle(START_X, START_Y, WIDTH, HEIGHT);
            BufferedImage bufferedImage = Main.ROBOT.createScreenCapture(rectangle);
            ImageAnalysis analysis = new ImageAnalysis(bufferedImage);
            GameInfo gameInfo = analysis.analyse();
            DecisionMaker decisionMaker = new DecisionMaker(gameInfo);
            ActionProducer keyboardProducer = decisionMaker.getActionProducer();
            keyboardProducer.makeGameAction();

        }
    }

    private static void makeScreenshot() throws IOException {
        Main.ROBOT.delay(10_000);
        Rectangle rectangle = new Rectangle(START_X, START_Y, WIDTH, HEIGHT);
        for (int i = 21; i < 101; i++){
            Main.ROBOT.delay(2000);
            BufferedImage bufferedImage = Main.ROBOT.createScreenCapture(rectangle);
            File file = new File("screenshots", i + ".jpg");
            ImageIO.write(bufferedImage, "png", file);
        }
    }
}
