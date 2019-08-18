/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.command;

import jp.co.daich.driver.LonlyOnlyDriver;
import jp.co.daich.driver.develop.util.event.listener.LoadNewPageListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 *
 * @author USER
 */
public class RkRkUrlGet {

    // ドライバー中でリスナーを管理するためのクラス
    EventFiringWebDriver eventFiringDriver = null;
    // URL取得のために使用するリスナー
    LoadNewPageListener eventListener = null;

    /**
     * 遷移URL取得用リスナーを開始
     */
    public void startListener() {
        //対象のWebDriverをイベント発生クラスに渡しインスタンスを作成する
        eventFiringDriver = new EventFiringWebDriver(LonlyOnlyDriver.getDriver());
        //イベント捕捉クラスのインスタンスを作成する
        eventListener = new LoadNewPageListener();
        //イベント捕捉クラスをイベント発生クラスへ登録する
        eventFiringDriver.register(eventListener);
    }

    /**
     * リスナーの登録解除を行い、直近の遷移したURLを返す
     *
     * @return
     */
    public String stopListener() {
        // イベントリスナーの登録解除
        eventFiringDriver.unregister(eventListener);
        // 直近の遷移したURLを返す
        return eventListener.getCurrentUrl();
    }

    /**
     * 現在のURLを返す
     *
     * @return
     */
    public String getCurrentUrl() {
        return eventListener.getCurrentUrl();
    }

}