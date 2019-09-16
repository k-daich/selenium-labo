/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.actions;

import jp.co.daich.driver.LonelyOnlyDriver;
import jp.co.daich.driver.develop.util.event.listener.ClickListener;
import org.openqa.selenium.By;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class EventListenerFromWebSiteTest extends TestBase {

    @Override
    public void doTest() {
        //イベント捕捉クラスのインスタンスを作成する
        ClickListener eventListener = new ClickListener();
        //イベント捕捉クラスをイベント発生クラスへ登録する
        LonelyOnlyDriver.registEventListener(eventListener);
        //指定したURLを開く
        LonelyOnlyDriver.get("https://www.google.co.jp");
        //「Gmail」のリンクテキストをクリックする
        LonelyOnlyDriver.findElement(By.linkText("Gmail")).click();
    }

}