/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.robot;

import java.awt.event.KeyEvent;
import jp.co.daich.robot.RobotAction;
import org.openqa.selenium.WebDriver;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class CntlF5keyTest extends TestBase {

    private WebDriver driver;

    public CntlF5keyTest() {
    }

//    @Test
    @Override
    public void doTest() {
        try {
            long waitTime = 3000;

            for (int i = 0; i < 5; i++) {
                // ctrl + F5  
                RobotAction.keyPress(KeyEvent.VK_CONTROL);
                RobotAction.keyPress(KeyEvent.VK_F5);

                // CTRL+F5 is now pressed 
                RobotAction.keyRelease(KeyEvent.VK_F5);
                RobotAction.keyRelease(KeyEvent.VK_CONTROL);

                Thread.sleep(waitTime);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
