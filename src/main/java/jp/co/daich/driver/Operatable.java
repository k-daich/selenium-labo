package jp.co.daich.driver;

import java.nio.file.Path;
import jp.co.daich.constants.properNoun.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 *
 * @author USER
 */
public interface Operatable {

    /**
     * @return the type
     */
    public Browser.TYPE getType();

    /**
     * 指定(By)した要素を返す
     *
     * @param by
     * @return 要素
     */
    public WebElement findElement(By by);

    /**
     * page forward
     *
     * @param url
     */
    public void get(String url);

    /**
     * quit driver
     */
    public void quit();

    /**
     *
     * @return
     */
    public String getCurrentUrl();

    /**
     * navigate to URL
     *
     * @param url
     */
    public void navigateTo(String url);

    /**
     * execute Javascript
     *
     * @param script
     * @return javascript result
     */
    public Object executeJavaScript(String script);

    /**
     * execute Javascript
     * @param scriptPath
     * @return javascript result
     */
    public Object executeJavaScript(Path scriptPath);

    /**
     * regist EventListener
     * @param eventListener
     */
    public void registEventListener(AbstractWebDriverEventListener eventListener);

    /**
     * 新しいウィンドウを開き、指定したURLへ遷移する
     * @param url
     * @return oldWindow(ウィンドウ戻す用)
     */
    public String openNewWindow(String url);

    /**
     * unregist EventListener
     * @param eventListener
     */
    public void unregistEventListener(AbstractWebDriverEventListener eventListener);

    /**
     * 
     * @param clickeEle
     * @param imgStorePath 
     */
    public void getClickHereScreenShot(WebElement clickeEle, String imgStorePath);

    /**
     * get browser head height
     *
     * @return browser head height
     */
    public int getBrowserHeadHeight();

    /**
     * scroll by javascript
     *
     * @param offset
     */
    public void scroll(int offset);

    /**
     * return Browser leftTop position
     *
     * @return position
     */
    public Point getBrowserPosition();

    /**
     * return Browser Size
     *
     * @return size
     */
    public Dimension getBrowserSize();

    /**
     * return Browser Height
     *
     * @return browser height
     */
    public int getBrowserHeight();

    /**
     * return Browser Width
     * @return BrowserWidth
     */
    public int getBrowserWidth();

    /**
     * @return page source
     */
    public String getPageSource();

    /**
     * robot press arg key
     *
     * @param keys
     */
    public void keyDown(Keys keys);

    /**
     * robot release arg key
     *
     * @param keys
     */
    public void keyUp(Keys keys);

    /**
     * sendKeys to ActiveFocus
     *
     * @param keys
     */
    public void sendKeys(String keys);

    /**
     * sendKeys to ActiveFocus
     *
     * @param keys
     */
    public void sendKeys(Keys keys);

    /**
     * sendKeys to ActiveFocus
     *
     * @param webElement
     * @param keys
     */
    public void sendKeys(WebElement webElement, String keys);

    /**
     * robot press arg mouseEvent
     *
     * @param by
     */
    public void moveCursorToElement(By by);

    /**
     * robot press arg mouseEvent
     *
     * @param toElement
     */
    public void moveCursorToElement(WebElement toElement);

    /**
     * click
     */
    public void mouseClick();

    /**
     * double click
     */
    public void mouseDoubleClick();

    /**
     * wait mill seconds
     *
     * @param millSec
     */
    public void wait(int millSec);

    /**
     * press and release Multi Keys
     *
     * @param keysies
     */
    public void pressKeys(String... keysies);

    /**
     * 指定した対象をクリックする
     *
     * @param wEle クリック対象
     */
    public void click(WebElement wEle);

    /**
     * return Action
     * @return 
     */
    public Actions getActions();

    /**
     * 引数より渡されたリスナーを登録/開始
     * @param eventListener
     */
    public void startListener(AbstractWebDriverEventListener eventListener);

    /**
     * 引数より渡されたリスナーを削除/停止
     * @param eventListener
     */
    public void stopListener(AbstractWebDriverEventListener eventListener);

    /**
     * @param imgStorePath 
     */
    public void getScreenShot(String imgStorePath);

}
