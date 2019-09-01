/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import jp.co.daich.driver.LonlyOnlyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

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
     * sendKeys to ActiveFocus
     *
     * @param keys
     */
    public static void sendKeys(String keys) {
        acts.sendKeys(keys).perform();
    }

    /**
     * robot press arg mouseEvent
     *
     * @param by
     */
    public static void moveCursorToElement(By by) {
        acts.moveToElement(findElement(by)).perform();
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
    public static void pressKeys(String... keysies) {
        LonlyOnlyDriver.findElement(By.tagName("html")).sendKeys(Keys.chord(keysies));

        /**
         * KeyDownとKeyUpは複数キーで実行するとエラーになるので没 以下がその時のコード / // // リスト順にキーを押下する //
         * for (String keysName : keysies) { //
         * keyDown(KeysMap.getKeys(keysName)); // } // // // リスト順を逆にする // //
         * String[] reversedArray = new Array<String>().reverse(keysies, new
         * String[keysies.length]); // // // リスト逆順にキーを離す // for (String keysName
         * : reversedArray) { // keyUp(KeysMap.getKeys(keysName)); // } }
         *
         */
    }

    /**
     * 指定した対象をクリックする
     *
     * @param wEle クリック対象
     */
    public static void click(WebElement wEle) {
        acts.click(wEle);
    }

    public static Actions getActions() {
        return acts;
    }
}
