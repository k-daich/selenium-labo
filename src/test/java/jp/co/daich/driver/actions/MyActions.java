/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import jp.co.daich.driver.LonlyOnlyDriver;

/**
 *
 * @author USER
 */
public class MyActions extends LonlyOnlyDriver {

    /**
     * Constructor
     */
    public MyActions() {
        super();
    }

    /**
     * robot press arg key
     *
     * @param keys
     */
    public static void keyDown(Keys keys) {
        acts.keyDown(keys).perform();
    }

    /**
     * robot release arg key
     *
     * @param keys
     */
    public static void keyUp(Keys keys) {
        acts.keyUp(keys).perform();
    }

    /**
     * robot press arg mouseEvent
     *
     * @param toElement
     */
    public static void moveCursorToElement(WebElement toElement) {
        acts.moveToElement(toElement).perform();
    }

    /**
     * click
     */
    public static void mouseClick() {
        acts.click().perform();
    }

    /**
     * double click
     */
    public static void mouseDoubleClick() {
        acts.doubleClick().perform();
    }

    /**
     * wait mill seconds
     *
     * @param millSec
     */
    public static void wait(int millSec) {
        try {
            Thread.sleep(millSec);
        } catch (InterruptedException e) {
            // 発生しない
        }
    }

    /**
     * press and release Multi Keys
     *
     * @param keysies
     */
    public static void pressAndReleaseMultipleKeys(Keys... keysies) {
        for (Keys keys : keysies) {
            keyDown(keys);
        }
        for (int i = keysies.length - 1; i >= 0; i--) {
            keyUp(keysies[i]);
        }
    }

    /**
     * 指定した対象をクリックする
     *
     * @param wEle クリック対象
     */
    public static void click(WebElement wEle) {
        acts.click(wEle);
    }
}
