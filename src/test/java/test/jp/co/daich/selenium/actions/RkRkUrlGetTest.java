/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.actions;

import jp.co.daich.command.RkRkUrlGet;
import jp.co.daich.driver.LonelyOnlyDriver;
import jp.co.daich.util.logger.MyLogger;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class RkRkUrlGetTest extends TestBase {

    @Override
    public void doTest() {
        RkRkUrlGet rkrkUrlGet = new RkRkUrlGet();
        rkrkUrlGet.startListener();

        LonelyOnlyDriver.navigateTo("https://caniuse.com/");
        MyLogger.printInfo("result RkRkUrlGetTest by MyListener-> " + rkrkUrlGet.getCurrentUrl());
        MyLogger.printInfo("result RkRkUrlGetTest by Driver -> " + LonelyOnlyDriver.getCurrentUrl());

        LonelyOnlyDriver.get("https://www.starbucks.co.jp/");

        String resultUrl = rkrkUrlGet.stopListener();
        MyLogger.printInfo("result RkRkUrlGetTest by MyListener-> " + resultUrl);
        MyLogger.printInfo("result RkRkUrlGetTest by Driver -> " + LonelyOnlyDriver.getCurrentUrl());
    }

}
