/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich;

import jp.co.daich.driver.LonelyOnlyDriver;
import jp.co.daich.driver.develop.util.WebElementParser;
import jp.co.daich.util.logger.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class TemporaryTest extends TestBase {

    /**
     * Invalidate default Constructor
     */
    public TemporaryTest() {
    }

    @Test
    @Override
    public void doTest() {
        Logger.printInfo("Result : " +
                WebElementParser.getIndexOfByTagNameFromRoot(LonelyOnlyDriver.findElement(By.linkText("ウインドウを操作する")))
        );
    }

}
