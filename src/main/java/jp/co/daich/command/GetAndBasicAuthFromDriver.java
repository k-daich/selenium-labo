/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.command;

import java.io.File;
import jp.co.daich.driver.LonelyMyDriver;
import jp.co.daich.driver.develop.util.ThreadUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 *
 * @author USER
 */
public class GetAndBasicAuthFromDriver {

    /**
     * invaliate default Constructor
     */
    private GetAndBasicAuthFromDriver() {
        // none
    }

    /**
     * basic Authorize break through by OS key events
     *
     * @param url
     * @param userName
     * @param passwd
     */
    public static void execute(String url, String userName, String passwd) {
        LonelyMyDriver.operate().sendKeys(Keys.chord(Keys.CONTROL, "t"));
        ThreadUtil.sleep(3000);
        LonelyMyDriver.operate().sendKeys(Keys.chord("t", "e","s","t"));
        ThreadUtil.sleep(3000);

        String absoluteCurrentDir = new File(".").getAbsoluteFile().getParent();
        LonelyMyDriver.operate().get("file:///" + absoluteCurrentDir + "/src/main/resources/docs/forCommand/basicAuthRelay.html");
        ThreadUtil.sleep(3000);

        // input URL
        LonelyMyDriver.operate().sendKeys(LonelyMyDriver.operate().findElement(By.id("urlFd")), url);
        ThreadUtil.sleep(3000);

        // click URL
        LonelyMyDriver.operate().click(LonelyMyDriver.operate().findElement(By.id("postFd")));

        ThreadUtil.sleep(3000);
        LonelyMyDriver.operate().sendKeys(Keys.TAB);
        ThreadUtil.sleep(3000);
        LonelyMyDriver.operate().sendKeys(Keys.ENTER);
        ThreadUtil.sleep(10000);

        // press Ctrl + L
//        WebElement webElement = myDriver.findElement(By.linkText("トップページ"));
//        Logger.printSevere("x is : " + webElement.getLocation().getX());
//        Logger.printSevere("y is : " + webElement.getLocation().getY());
//        myDriver.moveToElement(webElement, 0, -150).click().build().perform();
//        ThreadUtil.sleep(15000);
    }
}
