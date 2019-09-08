/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.command;

import jp.co.daich.driver.LonelyOnlyDriver;
import jp.co.daich.driver.actions.MyActions;
import jp.co.daich.driver.develop.util.logger.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author USER
 */
public class ClickHere {

    /**
     * invaliate default Constructor
     */
    private ClickHere() {
        // none
    }

    public static void execute(By by) {
        WebElement wEle = LonelyOnlyDriver.findElement(by);
        Logger.printSevere("element Location X is : " + wEle.getLocation().getX());
        Logger.printSevere("element Location Y is : " + wEle.getLocation().getY());
        LonelyOnlyDriver.getClickHereScreenShot(wEle);
        LonelyOnlyDriver.findElement(by).click();
        LonelyOnlyDriver.getScreenShot();
    }
}
