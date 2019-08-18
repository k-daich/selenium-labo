/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.actions;

import jp.co.daich.command.RkRkUrlGet;
import jp.co.daich.driver.LonlyOnlyDriver;
import jp.co.daich.driver.develop.util.logger.Logger;
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

        LonlyOnlyDriver.navigateTo("https://caniuse.com/");
        Logger.printSevere("result RkRkUrlGetTest by MyListener-> " + rkrkUrlGet.getCurrentUrl());
        Logger.printSevere("result RkRkUrlGetTest by Driver -> " + LonlyOnlyDriver.getCurrentUrl());

        LonlyOnlyDriver.get("https://www.starbucks.co.jp/");

        String resultUrl = rkrkUrlGet.stopListener();
        Logger.printSevere("result RkRkUrlGetTest by MyListener-> " + resultUrl);
        Logger.printSevere("result RkRkUrlGetTest by Driver -> " + LonlyOnlyDriver.getCurrentUrl());
    }

}