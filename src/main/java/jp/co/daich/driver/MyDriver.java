package jp.co.daich.driver;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Set;
import javax.imageio.ImageIO;
import jp.co.daich.constants.properNoun.Browser;
import jp.co.daich.constants.properNoun.WINDOWS;
import jp.co.daich.driver.browser.BrowserDependentAction;
import jp.co.daich.driver.develop.util.ThreadUtil;
import jp.co.daich.manage.evi.EviSeqManager;
import jp.co.daich.util.Calculator;
import jp.co.daich.util.file.MyInputStreamReader;
import jp.co.daich.util.file.image.ClickHereImageProcessor;
import jp.co.daich.util.logger.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 *
 * @author USER
 */
public final class MyDriver implements Operatable {

    /**
     * Builderを利用してインスタンス化すること
     * @param weDriver
     */
    public MyDriver(WebDriver weDriver) {
        this.webDriver = weDriver;

        // Actionsクラスを生成
        acts = new Actions(getWebDriver());

        //対象のWebDriverをイベント発生クラスに渡しインスタンスを作成する
        eventDriver = new EventFiringWebDriver(getWebDriver());
    }

    private final Actions acts;

    private final EventFiringWebDriver eventDriver;

    private final WebDriver webDriver;

     private BrowserDependentAction browserAction;

     private Browser.TYPE type;

     /**
     * get WebDriver
     * @return driver
     */
    private WebDriver getWebDriver() {
        return webDriver;
    }

//    /**
//     * Don't implement this setter
//     * @param driver
//     */
//    protected void setDriver(WebDriver driver) {
//        this.driver = driver;
//    }

    /**
     * @return the browserAction
     */
    public BrowserDependentAction getBrowserAction() {
        return browserAction;
    }

    /**
     * @param browserAction the browserAction to set
     */
    public void setBrowserAction(BrowserDependentAction browserAction) {
        this.browserAction = browserAction;
    }

    /**
     * @return the type
     */
    @Override
    public Browser.TYPE getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Browser.TYPE type) {
        this.type = type;
    }

    /**
     * 指定(By)した要素を返す
     *
     * @param by
     * @return 要素
     */
    @Override
    public WebElement findElement(By by) {
        return getWebDriver().findElement(by);
    }

    /**
     * page forward
     *
     * @param url
     */
    @Override
    public void get(String url) {
        getWebDriver().get(url);
    }

    /**
     * quit driver
     */
    @Override
    public void quit() {
        getWebDriver().quit();
    }

    /**
     *
     * @return
     */
    @Override
    public String getCurrentUrl() {
        return getWebDriver().getCurrentUrl();
    }

    /**
     * navigate to URL
     *
     * @param url
     */
    @Override
    public void navigateTo(String url) {
        getWebDriver().navigate().to(url);
    }

    /**
     * execute Javascript
     *
     * @param script
     * @return javascript result
     */
    @Override
    public Object executeJavaScript(String script) {
        Object result;
        MyLogger.printInfo("[Execute Javascript]" + script);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
        result = javascriptExecutor.executeScript(script);
        MyLogger.printInfo("[Execute Javascript] result : " + result);
        return result;
    }

    /**
     * execute Javascript
     * @param scriptPath
     * @return javascript result
     */
    @Override
    public Object executeJavaScript(Path scriptPath) {
        Object result;
        MyLogger.printInfo("[Execute Javascript]" + scriptPath);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
        result = javascriptExecutor.executeScript(MyInputStreamReader.readFile(scriptPath));
        MyLogger.printInfo("[Execute Javascript] result : " + result);
        return result;
    }

    /**
     * regist EventListener
     * @param eventListener
     */
    @Override
    public void registEventListener(AbstractWebDriverEventListener eventListener) {
        eventDriver.register(eventListener);
    }

    /**
     * 新しいウィンドウを開き、指定したURLへ遷移する
     * @param url
     * @return oldWindow(ウィンドウ戻す用)
     */
    @Override
    public String openNewWindow(String url) {
        // 新規ウィンドウを開く前のアクティブウィンドウ
        String oldWindow = getWebDriver().getWindowHandle();
        // 新規ウィンドウを開く前のアクティブウィンドウ
        Set<String> oldWindows = getWebDriver().getWindowHandles();

        // 新規ウィンドウを開く前のウィンドウ数
        int preWindowCount = getWebDriver().getWindowHandles().size();

        executeJavaScript("window.open()");
        int whileContinueCount = 0;
        // ウィンドウが開くまで待機
        while (preWindowCount == getWebDriver().getWindowHandles().size() && whileContinueCount < 10) {
            MyLogger.printInfo("[openWindow waitCount : ]" + ++whileContinueCount);
            ThreadUtil.sleep(100);
        }

        // 新規ウィンドウを開いた後のウィンドウリストのうち、新規ウィンドウを探し出す
        for (String window : getWebDriver().getWindowHandles()) {
            // 新規ウィンドウを開く前には存在しないウィンドウだった場合
            if (!oldWindows.contains(window)) {
                // アクティブウィンドウの切り替え
                getWebDriver().switchTo().window(window);
                // 新しいウィンドウで指定したURLへ遷移
                get(url);
                // 新しいウィンドウを開く前のアクティブウィンドウを返す
                return oldWindow;
            }
        }
        throw new RuntimeException("[class] LonelyMyDriver.operate() [method]openNewWindow 新しいウィンドウが見つかりませんでした。");
    }

    /**
     * unregist EventListener
     * @param eventListener
     */
    @Override
    public void unregistEventListener(AbstractWebDriverEventListener eventListener) {
        eventDriver.unregister(eventListener);
    }

    /**
     * 
     * @param clickeEle
     * @param imgStorePath 
     */
    @Override
    public void getClickHereScreenShot(WebElement clickeEle, String imgStorePath) {
        double widthRatio = 0;
        double heightRatio = 0;
        // スクリーンショット出力先
        String outputPath = imgStorePath + WINDOWS.FILE_SEPARATOR + EviSeqManager.getSeq() + "_output.png";

        // 入力/出力ストリーム開始
        try (
                // OutputStream(画像合成ファイル)
                OutputStream outStream = new FileOutputStream(outputPath);) {
            // webdriverで撮った一時スクショファイル
            BufferedImage scsho = ImageIO.read(new ByteArrayInputStream(((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES)));

            // スクショの書き出し
            ImageIO.write(scsho, "png", outStream);
            // 書き出したスクショと画面座標のサイズ比を算出(幅)
            widthRatio = Calculator.divide(
                    scsho.getWidth(),
                    Double.parseDouble(executeJavaScript("return window.innerWidth;").toString()));
            // 書き出したスクショと画面座標のサイズ比を算出(高さ)
            heightRatio = Calculator.divide(
                    scsho.getHeight(),
                    Double.parseDouble(executeJavaScript("return window.innerHeight;").toString()));
            MyLogger.printInfo("[widthRatio] is : " + widthRatio);
            MyLogger.printInfo("[heightRatio] is : " + heightRatio);
            MyLogger.printInfo("store screens shot at : " + outputPath);
        } catch (IOException ex) {
            MyLogger.printInfo(ex.getMessage());
        }
        MyLogger.printInfo("click here target location X : " + clickeEle.getLocation().getX());
        MyLogger.printInfo("click here target location Y : " + clickeEle.getLocation().getY());
        MyLogger.printInfo("click here target center position X : " + clickeEle.getRect().getWidth() / 2);
        MyLogger.printInfo("click here target center position Y : " + clickeEle.getRect().getHeight() / 2);

        // クリックヒア画像を生成
        ClickHereImageProcessor.composit(outputPath,
                // 書き出した画像とHTML座標の比率に差があるので掛け算する
                Calculator.multiply(
                        // 要素のX座標 + 要素自体の幅半分
                        clickeEle.getLocation().getX() + clickeEle.getRect().getWidth() / 2,
                        widthRatio),
                // 書き出した画像とHTML座標の比率に差があるので掛け算する
                Calculator.multiply(
                        // 要素のY座標 + 要素自体の高さ半分
                        clickeEle.getLocation().getY() + clickeEle.getRect().getHeight() / 2,
                        heightRatio));
    }

    /**
     * get browser head height
     *
     * @return browser head height
     */
    @Override
    public int getBrowserHeadHeight() {
        int innerHeight;
        innerHeight = Integer.parseInt(executeJavaScript("return window.innerHeight;").toString());
        return getBrowserSize().getHeight() - innerHeight;
    }

    /**
     * scroll by javascript
     *
     * @param offset
     */
    @Override
    public void scroll(int offset) {
        executeJavaScript("window.scrollTo(0, window.pageYOffset + " + offset + ");");
    }

    /**
     * return Browser leftTop position
     *
     * @return position
     */
    @Override
    public Point getBrowserPosition() {
        return getWebDriver().manage().window().getPosition();
    }

    /**
     * return Browser Size
     *
     * @return size
     */
    @Override
    public Dimension getBrowserSize() {
        return getWebDriver().manage().window().getSize();
    }

    /**
     * return Browser Height
     *
     * @return browser height
     */
    @Override
    public int getBrowserHeight() {
        return getWebDriver().manage().window().getSize().getHeight();
    }

    /**
     * return Browser Width
     * @return BrowserWidth
     */
    @Override
    public int getBrowserWidth() {
        return getWebDriver().manage().window().getSize().getWidth();
    }

    /**
     * set Browser Size
     * @param myDriver
     * @param width
     * @param height
     */
    public void setBrowserSize(MyDriver myDriver, int width, int height) {
            myDriver.getWebDriver().manage().window().setSize(new Dimension(width, height));
    }

    /**
     * @return page source
     */
    @Override
    public String getPageSource() {
        return getWebDriver().getPageSource();
    }

    /**
     * robot press arg key
     *
     * @param keys
     */
    @Override
    public void keyDown(Keys keys) {
        acts.keyDown(keys).perform();
    }

    /**
     * robot release arg key
     *
     * @param keys
     */
    @Override
    public void keyUp(Keys keys) {
        acts.keyUp(keys).perform();
    }

    /**
     * sendKeys to ActiveFocus
     *
     * @param keys
     */
    @Override
    public void sendKeys(String keys) {
        acts.sendKeys(keys).perform();
    }

    /**
     * sendKeys to ActiveFocus
     *
     * @param keys
     */
    @Override
    public void sendKeys(Keys keys) {
        acts.sendKeys(keys).perform();
    }

    /**
     * sendKeys to ActiveFocus
     *
     * @param webElement
     * @param keys
     */
    @Override
    public void sendKeys(WebElement webElement, String keys) {
        acts.sendKeys(webElement, keys).perform();
    }

    /**
     * robot press arg mouseEvent
     *
     * @param by
     */
    @Override
    public void moveCursorToElement(By by) {
        acts.moveToElement(findElement(by)).perform();
    }

    /**
     * robot press arg mouseEvent
     *
     * @param toElement
     */
    @Override
    public void moveCursorToElement(WebElement toElement) {
        acts.moveToElement(toElement).perform();
    }

    /**
     * click
     */
    @Override
    public void mouseClick() {
        acts.click().perform();
    }

    /**
     * double click
     */
    @Override
    public void mouseDoubleClick() {
        acts.doubleClick().perform();
    }

    /**
     * wait mill seconds
     *
     * @param millSec
     */
    @Override
    public void wait(int millSec) {
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
    @Override
    public void pressKeys(String... keysies) {
        findElement(By.tagName("html")).sendKeys(Keys.chord(keysies));

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
     * @param wEle クリック対象
     */
    @Override
    public void click(WebElement wEle) {
        acts.click(wEle);
    }

    /**
     * return Action
     * @return 
     */
    @Override
    public Actions getActions() {
        return acts;
    }

    /**
     * 引数より渡されたリスナーを登録/開始
     * @param eventListener
     */
    @Override
    public void startListener(AbstractWebDriverEventListener eventListener) {
        //イベント捕捉クラスをイベント発生クラスへ登録する
        eventDriver.register(eventListener);
    }

    /**
     * 引数より渡されたリスナーを削除/停止
     * @param eventListener
     */
    @Override
    public void stopListener(AbstractWebDriverEventListener eventListener) {
        //イベント捕捉クラスをイベント発生クラスへ登録する
        eventDriver.unregister(eventListener);
    }

    /**
     * @param imgStorePath 
     */
    @Override
    public void getScreenShot(String imgStorePath) {
        browserAction.getScreenShot(getWebDriver(), imgStorePath);
    }

}
