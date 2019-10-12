/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.command;

import jp.co.daich.driver.LonelyOnlyDriver;
import jp.co.daich.driver.develop.util.ThreadUtil;
import jp.co.daich.driver.develop.util.event.listener.ClickListener;
import jp.co.daich.util.file.MyFileUtil;
import jp.co.daich.util.logger.MyLogger;
import org.openqa.selenium.By;
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
        eventFiringDriver = new EventFiringWebDriver(LonelyOnlyDriver.getDriver());
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
    public String waitClick() {
        // 前回クリックされた要素
        String xpath = null;

        for (int i = 0; i < 5; i++) {
            // 3秒待機
            ThreadUtil.sleep(3000);
            MyLogger.printInfo("wait taimes : " + i);

            // TODO: Delete Test Code
            eventFiringDriver.findElement(By.cssSelector("a[href=\"https://www.seleniumqref.com/api/java/element_infoget/Java_getOptions.html\"]")).click();

            if (clickListener.getClickedXpath() != null) {
//                    && clickListener.getClickedWebElement() != lastClickedWebElement
                xpath = clickListener.getClickedXpath();
                break;
            }
        }
        // イベントリスナーの登録解除
        eventFiringDriver.unregister(clickListener);
        // xpathの候補リストを取得
        return xpath;
    }

    /**
     * htmlタグに設定された結果値を取得する
     */
    public static void getResult() {
        // clickListener.jsがhtmlタグに埋め込んだ値
        Object htmlAttribute = null;

        for (int i = 0; i < 120; i++) {
            htmlAttribute = null;
            // 3秒待機
            ThreadUtil.sleep(1500);
            htmlAttribute = LonelyOnlyDriver.executeJavaScript(
                    "return document.getElementsByTagName('html')[0].getAttribute('rkrkxpath');");
            // clickListenerによって埋め込まれていた場合
            if (htmlAttribute != null) {
                MyLogger.printInfo("[result] : " + htmlAttribute.toString());
                LonelyOnlyDriver.openNewWindow(
                        MyFileUtil.getFilePathFromProjectRoot(
                                "\\src\\main\\resources\\docs\\rkrkXpathGet\\clickListenerResult.html"
//                                "\\target\\classes\\docs\\rkrkXpathGet\\clickListenerResult.html"
                                        + "?xpath1="
                                        +  htmlAttribute.toString()));
            }
        }
    }
}
