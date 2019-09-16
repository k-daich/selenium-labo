/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.command;

import java.text.SimpleDateFormat;
import java.util.Date;
import jp.co.daich.constants.ProjectCommon;
import jp.co.daich.driver.LonelyOnlyDriver;
import jp.co.daich.util.file.FolderFactory;
import jp.co.daich.util.logger.Logger;
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
        Logger.printInfo("☆☆☆☆☆ClickHere Start☆☆☆☆☆");
        // 格納先ディレクトリを作成する
        FolderFactory.mkdir(IMG_STORE_PATH);

        WebElement wEle = LonelyOnlyDriver.findElement(by);
        Logger.printInfo("element Location X is : " + wEle.getLocation().getX());
        Logger.printInfo("element Location Y is : " + wEle.getLocation().getY());
        LonelyOnlyDriver.getClickHereScreenShot(wEle, IMG_STORE_PATH);
        LonelyOnlyDriver.findElement(by).click();
        LonelyOnlyDriver.getScreenShot(IMG_STORE_PATH);
        Logger.printInfo("★★★★★ClickHere Start★★★★★");
    }
}
