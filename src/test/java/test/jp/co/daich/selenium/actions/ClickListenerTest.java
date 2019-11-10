/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.actions;

import jp.co.daich.driver.LonelyMyDriver;
import jp.co.daich.javascript.executor.impl.ClickListenerExecutor;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class ClickListenerTest extends TestBase {

    @Override
    public void doTest() {
        new ClickListenerExecutor().run();
        LonelyMyDriver.operate().wait(50000);
    }
}
