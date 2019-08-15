package jp.co.daich.robot;

import java.awt.AWTException;
import java.awt.Robot;

/**
 * Singleton Pattern Robot
 *
 * @author USER
 */
public class LonelyRobot {

    private static Robot INSTANCE;

    /**
     * invalidate Constructor
     */
    private LonelyRobot() {
    }

    /**
     * return Singleton Robot
     *
     * @return
     */
    public static Robot getInstance() {
        if (INSTANCE == null) {
            try {
                return new Robot();
            } catch (AWTException e) {
                throw new RuntimeException("Robotクラスの生成に失敗した");
            }
        }
        return INSTANCE;
    }
}
