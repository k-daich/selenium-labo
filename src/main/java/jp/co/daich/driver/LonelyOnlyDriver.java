package jp.co.daich.driver;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import javax.imageio.ImageIO;
import jp.co.daich.constants.properNoun.Browser;
import jp.co.daich.constants.properNoun.WINDOWS;
import jp.co.daich.driver.develop.util.ThreadUtil;
import jp.co.daich.util.Calculator;
import jp.co.daich.util.file.MyInputStreamReader;
import jp.co.daich.util.file.image.ClickHereImageProcessor;
import jp.co.daich.util.logger.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 *
 * @author USER
 */
public class LonelyOnlyDriver extends MyDriver {

    private static int fileSeq = 0;
    private static final WebDriver driver;
    private static final EventFiringWebDriver eventDriver;
    protected static final Actions acts;

    static {
        driver = launchFirefoxDriver();
        //カレントウインドウのサイズを幅:100,高さ:200に設定する
//        driver.manage().window().setSize(new Dimension(512, 896));
        driver.manage().window().setSize(new Dimension(512, 768));
        // ChromeDriverまでのパスを設定する
        driver.get("https://www.google.co.jp");

        acts = new Actions(driver);

        //対象のWebDriverをイベント発生クラスに渡しインスタンスを作成する
        eventDriver = new EventFiringWebDriver(LonelyOnlyDriver.getDriver());
    }

    /**
     * setup chrome driver
     *
     * @return chromeDriver
     */
    private static WebDriver launchChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        System.setProperty("webdriver.chrome.driver", "src/main/java/jp/co/webdrivers/chromedriver.76.exe");
//        WebDriverManager.chromedriver().setup();
        type = Browser.TYPE.CHROME;
        return new ChromeDriver();
    }

    /**
     * setup edge driver
     *
     * @return edgeDriver
     */
    private static WebDriver launchEdgeDriver() {
        System.setProperty("webdriver.edge.driver", "src/main/java/jp/co/webdrivers/MicrosoftWebDriver.exe");
//        WebDriverManager.edgedriver().setup();
        type = Browser.TYPE.EDGE;
        return new EdgeDriver();
    }

    /**
     * setup chrome driver
     *
     * @return chromeDriver
     */
    private static WebDriver launchFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/java/jp/co/webdrivers/geckodriver0.26.0.exe");
//        WebDriverManager.firefoxdriver().setup();
        type = Browser.TYPE.FIREFOX;
        return new FirefoxDriver();
    }

    /**
     * 指定(By)した要素を返す
     *
     * @param by
     * @return 要素
     */
    public static WebElement findElement(By by) {
        return driver.findElement(by);
    }

    /**
     * page forward
     *
     * @param url
     */
    public static void get(String url) {
        driver.get(url);
    }

    /**
     * quit driver
     */
    public static void quit() {
        driver.quit();
    }

    /**
     * get WebDriver
     *
     * @return
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     *
     * @return
     */
    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * navigate to URL
     *
     * @param url
     */
    public static void navigateTo(String url) {
        driver.navigate().to(url);
    }

    /**
     * execute Javascript
     *
     * @param script
     * @return javascript result
     */
    public static Object executeJavaScript(String script) {
        Object result;
        MyLogger.printInfo("[Execute Javascript]" + script);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        result = javascriptExecutor.executeScript(script);
        MyLogger.printInfo("[Execute Javascript] result : " + result);
        return result;
    }

    /**
     * execute Javascript
     * @param scriptPath
     * @return javascript result
     */
    public static Object executeJavaScript(Path scriptPath) {
        Object result;
        MyLogger.printInfo("[Execute Javascript]" + scriptPath);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        result = javascriptExecutor.executeScript(MyInputStreamReader.readFile(scriptPath));
        MyLogger.printInfo("[Execute Javascript] result : " + result);
        return result;
    }

    /**
     * regist EventListener
     * @param eventListener
     */
    public static void registEventListener(AbstractWebDriverEventListener eventListener) {
        eventDriver.register(eventListener);
    }

    /**
     * 新しいウィンドウを開き、指定したURLへ遷移する
     * @param url
     * @return oldWindow(ウィンドウ戻す用)
     */
    public static String openNewWindow(String url) {
        // 新規ウィンドウを開く前のアクティブウィンドウ
        String oldWindow = driver.getWindowHandle();
        // 新規ウィンドウを開く前のアクティブウィンドウ
        Set<String> oldWindows = driver.getWindowHandles();

        // 新規ウィンドウを開く前のウィンドウ数
        int preWindowCount = driver.getWindowHandles().size();

        executeJavaScript("window.open()");
        int whileContinueCount = 0;
        // ウィンドウが開くまで待機
        while (preWindowCount == driver.getWindowHandles().size() && whileContinueCount < 10) {
            MyLogger.printInfo("[openWindow waitCount : ]" + ++whileContinueCount);
            ThreadUtil.sleep(100);
        }

        // 新規ウィンドウを開いた後のウィンドウリストのうち、新規ウィンドウを探し出す
        for (String window : driver.getWindowHandles()) {
            // 新規ウィンドウを開く前には存在しないウィンドウだった場合
            if (!oldWindows.contains(window)) {
                // アクティブウィンドウの切り替え
                driver.switchTo().window(window);
                // 新しいウィンドウで指定したURLへ遷移
                get(url);
                // 新しいウィンドウを開く前のアクティブウィンドウを返す
                return oldWindow;
            }
        }
        throw new RuntimeException("[class] LonelyOnlyDriver [method]openNewWindow 新しいウィンドウが見つかりませんでした。");
    }

    /**
     * ファイルのインデックスを返す
     * @return fileIndex
     */
    public static int getFileIndex() {
        return fileSeq;
    }

    /**
     * unregist EventListener
     * @param eventListener
     */
    public static void unregistEventListener(AbstractWebDriverEventListener eventListener) {
        eventDriver.unregister(eventListener);
    }

    /**
     * 
     * @param clickeEle
     * @param imgStorePath 
     */
    public static void getClickHereScreenShot(WebElement clickeEle, String imgStorePath) {
        double widthRatio = 0;
        double heightRatio = 0;
        // スクリーンショット出力先
        String outputPath = imgStorePath + WINDOWS.FILE_SEPARATOR + fileSeq++ + "_output.png";

        // 入力/出力ストリーム開始
        try (
                // OutputStream(画像合成ファイル)
                OutputStream outStream = new FileOutputStream(outputPath);) {
            // webdriverで撮った一時スクショファイル
            BufferedImage scsho = ImageIO.read(new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

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

    public static void getScreenShot(String imgStorePath) {
        // webdriverで撮った一時スクショファイル
        File sFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        // スクリーンショット出力先
        String outputPath = imgStorePath + WINDOWS.FILE_SEPARATOR + fileSeq++ + "_output.png";

        // 入力/出力ストリーム開始
        try (
                FileInputStream inStream = new FileInputStream(sFile);
                FileOutputStream outStream = new FileOutputStream(outputPath);) {
            int readBytes;
            // 入力ストリームの読み込んだバイト数だけファイルに書き出す
            while ((readBytes = inStream.read()) != -1) {
                outStream.write(readBytes);
            }
            MyLogger.printInfo("store screens shot at : " + outputPath);
        } catch (IOException ex) {
            MyLogger.printInfo(ex.getMessage());
        }
    }

    /**
     * get browser head height
     *
     * @return browser head height
     */
    public static int getBrowserHeadHeight() {
        int innerHeight;
        innerHeight = Integer.parseInt(executeJavaScript("return window.innerHeight;").toString());
        return getBrowserSize().getHeight() - innerHeight;
    }

    /**
     * scroll by javascript
     *
     * @param offset
     */
    public static void scroll(int offset) {
        executeJavaScript("window.scrollTo(0, window.pageYOffset + " + offset + ");");
    }

    /**
     * return Browser leftTop position
     *
     * @return position
     */
    public static Point getBrowserPosition() {
        return driver.manage().window().getPosition();
    }

    /**
     * return Browser Size
     *
     * @return size
     */
    public static Dimension getBrowserSize() {
        return driver.manage().window().getSize();
    }

    /**
     * return Browser Height
     *
     * @return browser height
     */
    public static int getBrowserHeight() {
        return driver.manage().window().getSize().getHeight();
    }

    /**
     * return Browser Width
     */
    public static int getBrowserWidth() {
        return driver.manage().window().getSize().getWidth();
    }

}
