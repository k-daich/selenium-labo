/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.command;

import jp.co.daich.constants.ProjectCommon;
import jp.co.daich.driver.LonelyOnlyDriver;
import jp.co.daich.util.file.FolderFactory;
import jp.co.daich.util.logger.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author USER
 */
public class ClickHere {

    private static final String IMG_STORE_PATH = ProjectCommon.EVI_DIR + "clickHere_" + ProjectCommon.DATE_TEXT;

    /**
     * invaliate default Constructor
     */
    private ClickHere() {
        // none
    }

    public static void execute(By by) {
        MyLogger.printInfo("☆☆☆☆☆ClickHere Start☆☆☆☆☆");
        // 格納先ディレクトリを作成する
        FolderFactory.mkdir(IMG_STORE_PATH);

        WebElement wEle = LonelyOnlyDriver.findElement(by);

//        LonelyOnlyDriver.getClickHereScreenShot(wEle, IMG_STORE_PATH);
//        LonelyOnlyDriver.getClickHereScreenShot2(wEle, IMG_STORE_PATH);
//        LonelyOnlyDriver.getClickHereScreenShotGettingLocationByJavascript(wEle, IMG_STORE_PATH);
        LonelyOnlyDriver.getClickHereScreenShotAddingPngByJavascript(wEle, IMG_STORE_PATH);

        LonelyOnlyDriver.findElement(by).click();
        LonelyOnlyDriver.getScreenShot(IMG_STORE_PATH);
        MyLogger.printInfo("★★★★★ClickHere End★★★★★");
    }
}
