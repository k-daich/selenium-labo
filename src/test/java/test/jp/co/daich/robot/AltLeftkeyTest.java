/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.robot;

import java.awt.event.KeyEvent;
import jp.co.daich.robot.RobotAction;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class AltLeftkeyTest extends TestBase {

    public AltLeftkeyTest() {
    }

    @Test
    @Override
    public void doTest() {
        try {
            long waitTime = 3000;

            // Alt + ←  
            RobotAction.keyPress(KeyEvent.VK_ALT);
            RobotAction.keyPress(KeyEvent.VK_LEFT);

            // Alt + ←   is now pressed 
            RobotAction.keyRelease(KeyEvent.VK_LEFT);
            RobotAction.keyRelease(KeyEvent.VK_ALT);

            Thread.sleep(waitTime);

            // Alt + ←  
            RobotAction.keyPress(KeyEvent.VK_ALT);
            RobotAction.keyPress(KeyEvent.VK_RIGHT);

            // Alt + ←   is now pressed 
            RobotAction.keyRelease(KeyEvent.VK_RIGHT);
            RobotAction.keyRelease(KeyEvent.VK_ALT);

            Thread.sleep(waitTime);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
