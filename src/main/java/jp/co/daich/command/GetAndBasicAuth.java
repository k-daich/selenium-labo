/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.command;

import java.awt.event.KeyEvent;
import java.io.File;
import jp.co.daich.driver.develop.util.ThreadUtil;
import jp.co.daich.robot.RobotAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author USER
 */
public class GetAndBasicAuth {

    /**
     * invaliate default Constructor
     */
    private GetAndBasicAuth() {
        // none
    }

    /**
     * basic Authorize break through by OS key events
     * @param url
     * @param userName
     * @param passwd 
     */
    public static void execute(String url, String userName, String passwd) {
        // press Ctrl + L
        RobotAction.pressKeys(
                KeyEvent.VK_CONTROL,
                KeyEvent.VK_L);

        RobotAction.sendKeysByKoPiPe(url);

        // press Enter
        RobotAction.pressKeys(KeyEvent.VK_ENTER);
        ThreadUtil.sleep(2000);

        RobotAction.sendKeysByKoPiPe(userName);

        // press Tab
        RobotAction.pressKeys(KeyEvent.VK_TAB);
        ThreadUtil.sleep(300);
        RobotAction.sendKeysByKoPiPe(passwd);
        ThreadUtil.sleep(300);

        // press Enter
        RobotAction.pressKeys(KeyEvent.VK_ENTER);
        ThreadUtil.sleep(5000);
    }
}
