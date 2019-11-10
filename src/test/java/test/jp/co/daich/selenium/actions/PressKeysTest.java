/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.actions;

import jp.co.daich.driver.LonelyMyDriver;
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
        LonelyMyDriver.operate().get("https://teratail.com/questions/433");

        LonelyMyDriver.operate().pressKeys(
                "ALT",
                "LEFT");
        LonelyMyDriver.operate().wait(3000);

        LonelyMyDriver.operate().findElement(By.tagName("body")).sendKeys(Keys.F5);
        LonelyMyDriver.operate().pressKeys(
                "ALT",
                "LEFT");
        LonelyMyDriver.operate().pressKeys(
                "ALT",
                "RIGHT");

        LonelyMyDriver.operate().wait(3000);

        LonelyMyDriver.operate().findElement(By.tagName("body")).sendKeys(Keys.F5);
        LonelyMyDriver.operate().pressKeys(
                "F5");

        LonelyMyDriver.operate().pressKeys(
                "F5");

    }   
}
