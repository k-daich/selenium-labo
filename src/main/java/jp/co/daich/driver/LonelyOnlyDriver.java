/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import jp.co.daich.constants.properNoun.WINDOWS;
import jp.co.daich.driver.develop.util.WebElementParser;
import jp.co.daich.robot.RobotAction;
import jp.co.daich.util.MyStringUtil;
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
public class LonelyOnlyDriver {

    private static int fileSeq = 0;
    private static final WebDriver driver;
    private static final EventFiringWebDriver eventDriver;
    protected static final Actions acts;

    static {
        driver = launchChromeDriver();
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
//        System.setProperty("webdriver.chrome.driver", "src/main/java/jp/co/webdrivers/chromedriver.76.exe");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    /**
     * setup edge driver
     *
     * @return edgeDriver
     */
    private static WebDriver launchEdgeDriver() {
//        System.setProperty("webdriver.edge.driver", "src/main/java/jp/co/webdrivers/MicrosoftWebDriver.exe");
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    /**
     * setup chrome driver
     *
     * @return chromeDriver
     */
    private static WebDriver launchFirefoxDriver() {
//        System.setProperty("webdriver.chrome.driver", "src/main/java/jp/co/webdrivers/chromedriver.76.exe");
        WebDriverManager.firefoxdriver().setup();
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
        MyLogger.printInfo("[Execute Javascript]" + script);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return javascriptExecutor.executeScript(script);
    }

    /**
     * regist EventListener
     *
     * @param eventListener
     */
    public static void registEventListener(AbstractWebDriverEventListener eventListener) {
        eventDriver.register(eventListener);
    }

    /**
     * ファイルのインデックスを返す
     *
     * @return fileIndex
     */
    public static int getFileIndex() {
        return fileSeq;
    }

    /**
     * unregist EventListener
     *
     * @param eventListener
     */
    public static void unregistEventListener(AbstractWebDriverEventListener eventListener) {
        eventDriver.unregister(eventListener);
    }

    public static void getClickHereScreenShot(WebElement clickeEle, String imgStorePath) {
        // webdriverで撮った一時スクショファイル
        File sFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
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
        MyLogger.printInfo("click here target location X : " + clickeEle.getLocation().getX());
        MyLogger.printInfo("click here target location X : " + clickeEle.getLocation().getY());
        MyLogger.printInfo("click here target center position X : " + clickeEle.getRect().getWidth() / 2);
        MyLogger.printInfo("click here target center position Y : " + clickeEle.getRect().getHeight() / 2);
        // クリックヒア画像を生成
        ClickHereImageProcessor.composit(outputPath,
                clickeEle.getLocation().getX() + clickeEle.getRect().getWidth() / 2,
                clickeEle.getLocation().getY() + clickeEle.getRect().getHeight() / 2);
    }

    public static void getClickHereScreenShot2(WebElement clickeEle, String imgStorePath) {
        // webdriverで撮った一時スクショファイル
        File sFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // スクリーンショット出力先
        String outputPath = imgStorePath + WINDOWS.FILE_SEPARATOR + fileSeq++ + "_output.png";

        // スクリーンショット生成
        RobotAction.takeBrowserPicture(outputPath);
        MyLogger.printInfo("store screens shot at : " + outputPath);

        MyLogger.printInfo("click here target center position X : " + clickeEle.getRect().getWidth() / 2);
        MyLogger.printInfo("click here target center position Y : " + clickeEle.getRect().getHeight() / 2);
        // クリックヒア画像を生成
        ClickHereImageProcessor.composit(outputPath,
                clickeEle.getLocation().getX() + clickeEle.getRect().getWidth() / 2,
                clickeEle.getLocation().getY() + clickeEle.getRect().getHeight() / 2 + getBrowserHeadHeight());
    }

    public static void getClickHereScreenShotGettingLocationByJavascript(WebElement clickeEle, String imgStorePath) {
        int indexOfTagsBySameNameFromRoot = WebElementParser.getIndexOfByTagNameFromRoot(clickeEle);

        MyLogger.printInfo("[click href] " + executeJavaScript("return document.getElementsByTagName('" + clickeEle.getTagName() + "')[" + indexOfTagsBySameNameFromRoot + "].getAttribute('href');").toString());

        int locationX = Integer.parseInt(
                MyStringUtil.subString(
                        executeJavaScript("return document.getElementsByTagName('" + clickeEle.getTagName() + "')[" + indexOfTagsBySameNameFromRoot + "].getBoundingClientRect().left;").toString(),
                        '.'));
        int locationY = Integer.parseInt(
                MyStringUtil.subString(
                        executeJavaScript("return document.getElementsByTagName('" + clickeEle.getTagName() + "')[" + indexOfTagsBySameNameFromRoot + "].getBoundingClientRect().top;").toString(),
                        '.'));
        int eleWidth = Integer.parseInt(
                MyStringUtil.subString(
                        executeJavaScript("return document.getElementsByTagName('" + clickeEle.getTagName() + "')[" + indexOfTagsBySameNameFromRoot + "].getBoundingClientRect().width;").toString(),
                        '.'));
        int eleHeight = Integer.parseInt(
                MyStringUtil.subString(
                        executeJavaScript("return document.getElementsByTagName('" + clickeEle.getTagName() + "')[" + indexOfTagsBySameNameFromRoot + "].getBoundingClientRect().height;").toString(),
                        '.'));
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
        MyLogger.printInfo("click here target location X getting By Javascript : " + locationX / 2);
        MyLogger.printInfo("click here target location Y getting By Javascript : " + locationY / 2);
        MyLogger.printInfo("click here target center position X getting By Javascript : " + eleWidth / 2);
        MyLogger.printInfo("click here target center position Y getting By Javascript : " + eleHeight / 2);
        // クリックヒア画像を生成
        ClickHereImageProcessor.composit(outputPath,
                locationX + eleWidth / 2,
                locationY + eleHeight / 2);
    }

    public static void getClickHereScreenShotAddingPngByJavascript(WebElement clickeEle, String imgStorePath) {
        // webdriverで撮った一時スクショファイル
        File sFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
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
        MyLogger.printInfo("click here target location X : " + clickeEle.getLocation().getX());
        MyLogger.printInfo("click here target location X : " + clickeEle.getLocation().getY());
        MyLogger.printInfo("click here target center position X : " + clickeEle.getRect().getWidth() / 2);
        MyLogger.printInfo("click here target center position Y : " + clickeEle.getRect().getHeight() / 2);
        executeJavaScript("var img = document.createElement('img');\n"
                + "img.style.position = 'absolute';\n"
                + "img.style.left = '" + clickeEle.getLocation().getX() + "px';\n"
                + "img.style.top = '" + clickeEle.getLocation().getY() + "px';\n"
                + "img.src = '\\images\\Title_logo.png';\n"
                + "\n"
                + "document.getElementsByTagName('html')[0].appendChild(img);");
        // webdriverで撮った一時スクショファイル
        sFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // スクリーンショット出力先
        outputPath = imgStorePath + WINDOWS.FILE_SEPARATOR + fileSeq + "_output2_addedPngByJs.png";

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
