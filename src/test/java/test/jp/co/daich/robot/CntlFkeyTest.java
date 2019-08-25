/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.robot;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import jp.co.daich.robot.RobotAction;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class CntlFkeyTest extends TestBase {

    public CntlFkeyTest() {
    }

    @Test
    @Override
    public void doTest() {
        try {
            long waitTime = 3000;

            // ctrl + F  
            RobotAction.keyPress(KeyEvent.VK_CONTROL);
            RobotAction.keyPress(KeyEvent.VK_F);

            // CTRL+F is now pressed 
            RobotAction.keyRelease(KeyEvent.VK_F);
            RobotAction.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(waitTime);
            String text = "CSS Grid";
            StringSelection stringSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            clipboard.setContents(stringSelection, stringSelection);

            RobotAction.keyPress(KeyEvent.VK_CONTROL);
            RobotAction.keyPress(KeyEvent.VK_V);
            RobotAction.keyRelease(KeyEvent.VK_V);
            RobotAction.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(waitTime);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
