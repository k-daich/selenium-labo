/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.robot;

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
     * @param x
     * @param y
     */
    public static void mouseMove(int x, int y) {
        LonelyRobot.getInstance().mouseMove(x,y);
    }

    /**
     * robot delay mill seconds
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
    public static void pressAndReleaseMultipleKeys(int... keyEvents) {
        for (int keyEvent : keyEvents) {
            RobotAction.keyPress(keyEvent);
        }
        for (int i = keyEvents.length - 1; i >= 0; i--) {
            RobotAction.keyRelease(keyEvents[i]);
        }
    }
}
