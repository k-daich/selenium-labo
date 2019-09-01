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
public class PushkeyTest extends TestBase {

    public PushkeyTest() {
    }

    @Test
    @Override
    public void doTest() {
        try {
            for (int i : new int[]{0, 1, 2}) {
                long waitTime = 2000;
                RobotAction.pressKeys(KeyEvent.VK_ALT, KeyEvent.VK_LEFT);
                Thread.sleep(waitTime);
                RobotAction.pressKeys(KeyEvent.VK_ALT, KeyEvent.VK_RIGHT);
                Thread.sleep(waitTime);
                RobotAction.pressKeys(KeyEvent.VK_CONTROL, KeyEvent.VK_F);
                Thread.sleep(waitTime);
                RobotAction.pressKeys(KeyEvent.VK_ESCAPE);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
