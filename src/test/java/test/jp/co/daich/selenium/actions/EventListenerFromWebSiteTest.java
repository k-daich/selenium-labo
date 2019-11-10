package test.jp.co.daich.selenium.actions;

import jp.co.daich.driver.LonelyMyDriver;
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
        LonelyMyDriver.operate().registEventListener(eventListener);
        //指定したURLを開く
        LonelyMyDriver.operate().get("https://www.google.co.jp");
        //「Gmail」のリンクテキストをクリックする
        LonelyMyDriver.operate().findElement(By.linkText("Gmail")).click();
    }

}
