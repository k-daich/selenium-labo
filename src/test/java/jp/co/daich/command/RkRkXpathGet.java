/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.command;

import java.util.List;
import jp.co.daich.driver.LonlyOnlyDriver;
import jp.co.daich.driver.actions.MyActions;
import jp.co.daich.driver.develop.util.ThreadUtil;
import jp.co.daich.driver.develop.util.WebElementParser;
import jp.co.daich.driver.develop.util.event.listener.ClickListener;
import jp.co.daich.driver.develop.util.logger.Logger;
import jp.co.daich.driver.develop.util.xpath.candidate.FullPath;
import jp.co.daich.driver.develop.util.xpath.candidate.base.CandidateBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 *
 * @author USER
 */
public class RkRkXpathGet {

    // ドライバー中でリスナーを管理するためのクラス
    private static EventFiringWebDriver eventFiringDriver = null;
    // URL取得のために使用するリスナー
    private static ClickListener clickListener = null;

    /**
     * クリックされた要素情報取得用リスナーを開始
     */
    public void startListener() {
        //対象のWebDriverをイベント発生クラスに渡しインスタンスを作成する
        eventFiringDriver = new EventFiringWebDriver(LonlyOnlyDriver.getDriver());
        //イベント捕捉クラスのインスタンスを作成する
        clickListener = new ClickListener();
        //イベント捕捉クラスをイベント発生クラスへ登録する
        eventFiringDriver.register(clickListener);
    }

    /**
     * リスナー起動中にクリックした要素のxpathを返す
     *
     * @return 取得したxpath候補(List型)
     */
    public List<String> waitClick() {
        CandidateBase candidate = new FullPath();
        // 前回クリックされた要素
        WebElement lastClickedWebElement = null;

        for (int i = 0; i < 5; i++) {
            // 3秒待機
            ThreadUtil.sleep(3000);
            Logger.printSevere("wait taimes : " + i);

            // TODO: Delete Test Code
            MyActions.click(LonlyOnlyDriver.findElement(By.linkText("セレクトタグに含まれるオプションを取得する")));

            if (clickListener.getClickedWebElement() != null
                    && clickListener.getClickedWebElement() != lastClickedWebElement) {
                lastClickedWebElement = clickListener.getClickedWebElement();
            }
        }
        // イベントリスナーの登録解除
        eventFiringDriver.unregister(clickListener);
        // xpathの候補リストを取得
        return candidate.getXpaths(WebElementParser.getTagHierarchy(lastClickedWebElement));
    }

}
