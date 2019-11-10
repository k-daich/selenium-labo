/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.robot;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import jp.co.daich.driver.LonelyMyDriver;
import jp.co.daich.util.Calculator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

/**
 *
 * @author USER
 */
public class RobotAction {

    /**
     * robot press arg key
     *
     * @param keyEvent
     */
    public static void keyPress(int keyEvent) {
        LonelyRobot.getInstance().keyPress(keyEvent);
    }

    /**
     * robot release arg key
     *
     * @param keyEvent
     */
    public static void keyRelease(int keyEvent) {
        LonelyRobot.getInstance().keyRelease(keyEvent);
    }

    /**
     * robot press arg mouseEvent
     *
     * @param inputEvent
     */
    public static void mousePress(int inputEvent) {
        LonelyRobot.getInstance().mousePress(inputEvent);
    }

    /**
     * robot release arg mouseEvent
     *
     * @param inputEvent
     */
    public static void mouseRelease(int inputEvent) {
        LonelyRobot.getInstance().mouseRelease(inputEvent);
    }

    /**
     * robot rotate wheel at arg times
     *
     * @param degree
     */
    public static void mouseWheel(int degree) {
        LonelyRobot.getInstance().mouseWheel(degree);
    }

    /**
     * robot move mouse at args X and Y
     *
     * @param x
     * @param y
     */
    public static void mouseMove(int x, int y) {
        LonelyRobot.getInstance().mouseMove(x, y);
    }

    /**
     * robot delay mill seconds
     *
     * @param millSec
     */
    public static void delay(int millSec) {
        LonelyRobot.getInstance().delay(millSec);
    }

    /**
     * press and release Multi Keys
     *
     * @param keyEvents
     */
    public static void pressKeys(int... keyEvents) {
        for (int keyEvent : keyEvents) {
            RobotAction.keyPress(keyEvent);
        }
        for (int i = keyEvents.length - 1; i >= 0; i--) {
            RobotAction.keyRelease(keyEvents[i]);
        }
    }

    /**
     * コピペを利用して文字列を送る
     *
     * @param text
     */
    public static void sendKeysByKoPiPe(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        RobotAction.keyPress(KeyEvent.VK_CONTROL);
        RobotAction.keyPress(KeyEvent.VK_V);
        RobotAction.keyRelease(KeyEvent.VK_V);
        RobotAction.keyRelease(KeyEvent.VK_CONTROL);
    }

    /**
     * take picture for browser
     *
     * @param imagePath
     */
    public static void takeBrowserPicture(String imagePath) {
        Point pos = LonelyMyDriver.operate().getBrowserPosition();
        Dimension size = LonelyMyDriver.operate().getBrowserSize();

        // キャプチャの範囲
        Rectangle bounds = new Rectangle(
                pos.getX(),
                pos.getY(),
                Calculator.multiply(size.getWidth(), 1.25),
                Calculator.multiply(size.getHeight(), 1.25));

        try {
            BufferedImage image = LonelyRobot.getInstance().createScreenCapture(bounds);
            // イメージファイル出力処理
            ImageIO.write(image, "png", new File(imagePath));
        } catch (IOException ex) {
            throw new RuntimeException("Robotのスクショ作成処理が失敗",
                    ex);
        }
    }

}
