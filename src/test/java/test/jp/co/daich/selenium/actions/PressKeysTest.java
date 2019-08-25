/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.actions;

import jp.co.daich.driver.LonlyOnlyDriver;
import jp.co.daich.driver.actions.MyActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class PressKeysTest extends TestBase {

    @Override
    public void doTest() {
        MyActions.get("https://teratail.com/questions/433");

        MyActions.pressKeys(
                "ALT",
                "LEFT");
        MyActions.wait(3000);

        LonlyOnlyDriver.findElement(By.tagName("body")).sendKeys(Keys.F5);
        MyActions.pressKeys(
                "ALT",
                "LEFT");
        MyActions.pressKeys(
                "ALT",
                "RIGHT");

        MyActions.wait(3000);

        LonlyOnlyDriver.findElement(By.tagName("body")).sendKeys(Keys.F5);
        MyActions.pressKeys(
                "F5");

        MyActions.pressKeys(
                "F5");

    }   
}
