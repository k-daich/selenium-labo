/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import jp.co.daich.robot.RobotAction;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class F5keyTest extends TestBase {

    public F5keyTest() {
    }

    @Test
    @Override
    public void doTest() {
        try {
            long waitTime = 3000;
            Robot robot = new Robot();

            for (int i = 0; i < 5; i++) {
                // ctrl + F5  
                RobotAction.keyPress(KeyEvent.VK_F5);

                // CTRL+F5 is now pressed 
                RobotAction.keyRelease(KeyEvent.VK_F5);

                Thread.sleep(waitTime);
            }

        } catch (InterruptedException | AWTException e) {
            e.printStackTrace();
        }
    }
}
