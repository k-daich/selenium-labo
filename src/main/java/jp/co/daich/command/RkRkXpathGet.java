package jp.co.daich.command;

import jp.co.daich.driver.LonelyMyDriver;
import jp.co.daich.driver.develop.util.ThreadUtil;
import jp.co.daich.driver.develop.util.event.listener.ClickListener;
import jp.co.daich.util.file.MyFileUtil;
import jp.co.daich.util.logger.MyLogger;
import org.openqa.selenium.By;

/**
 *
 * @author USER
 */
public class RkRkXpathGet {

    // URL取得のために使用するリスナー
    private static ClickListener clickListener = null;

    
    /**
     * クリックされた要素情報取得用リスナーを開始
     */
    public void startListener() {
        //イベント捕捉クラスのインスタンスを作成する
        clickListener = new ClickListener();
        //イベント捕捉クラスをイベント発生クラスへ登録する
        LonelyMyDriver.operate().startListener(clickListener);
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
            LonelyMyDriver.operate().findElement(By.cssSelector("a[href=\"https://www.seleniumqref.com/api/java/element_infoget/Java_getOptions.html\"]")).click();

            if (clickListener.getClickedXpath() != null) {
//                    && clickListener.getClickedWebElement() != lastClickedWebElement
                xpath = clickListener.getClickedXpath();
                break;
            }
        }
        // イベントリスナーの登録解除
        LonelyMyDriver.operate().stopListener(clickListener);
        // xpathの候補リストを取得
        return xpath;
    }

    /**
     * htmlタグに設定された結果値を取得する
     */
    public static void getResult() {
        // clickListener.jsがhtmlタグに埋め込んだ値
        Object htmlAttribute = null;

        for (int i = 0; i < 60; i++) {
            htmlAttribute = null;
            // 3秒待機
            ThreadUtil.sleep(1000);
            htmlAttribute = LonelyMyDriver.operate().executeJavaScript(
                    "return document.getElementsByTagName('html')[0].getAttribute('rkrkxpath');");
            // clickListenerによって埋め込まれていた場合
            if (htmlAttribute != null) {
                MyLogger.printInfo("[result] : " + htmlAttribute.toString());
                LonelyMyDriver.operate().openNewWindow(
                        "file://" +
                        MyFileUtil.getFilePathFromProjectRoot(
                                "\\src\\main\\resources\\docs\\rkrkXpathGet\\clickListenerResult.html"
//                                "\\target\\classes\\docs\\rkrkXpathGet\\clickListenerResult.html"
                                        + "?xpath1="
                                        +  htmlAttribute.toString()));
            }
        }
    }
}
