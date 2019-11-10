/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.robot;

import jp.co.daich.driver.LonelyMyDriver;
import jp.co.daich.robot.RobotAction;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class WheelkeyTest extends TestBase {

    public WheelkeyTest() {
    }

    @Test
    @Override
    public void doTest() {
        LonelyMyDriver.operate().get("http://vermeer.hatenablog.jp/entry/2018/05/30/171915");
        try {
            long waitTime = 1000;

            for (int i = 0; i < 10; i++) {
                // wheel 3 degrees
                RobotAction.mouseWheel(3);
                Thread.sleep(waitTime);
            }

            for (int i = 0; i < 10; i++) {
                // wheel 3 degrees
                RobotAction.mouseWheel(-3);
                Thread.sleep(waitTime);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
