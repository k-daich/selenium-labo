/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 *
 * @author USER
 */
public class LonelyOnlyDriver {

    private static final WebDriver driver;
    private static final EventFiringWebDriver eventDriver;
    protected static final Actions acts;

    static {
        // ChromeDriverまでのパスを設定する
        System.setProperty("webdriver.chrome.driver", "src/main/java/jp/co/webdrivers/chromedriver.76.exe");
//        System.setProperty("webdriver.edge.driver", "src/main/java/jp/co/webdrivers/MicrosoftWebDriver.exe");

        WebDriverManager.edgedriver().setup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.co.jp");

        acts = new Actions(driver);

        //対象のWebDriverをイベント発生クラスに渡しインスタンスを作成する
        eventDriver = new EventFiringWebDriver(LonelyOnlyDriver.getDriver());

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
     */
    public static void executeJavaScript(String script) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(script);
    }
    
    /**
     * regist EventListener
     * @param eventListener
     */
    public static void registEventListener(AbstractWebDriverEventListener eventListener) {
        eventDriver.register(eventListener);
    }

    /**
     * unregist EventListener
     * @param eventListener
     */
    public static void unregistEventListener(AbstractWebDriverEventListener eventListener) {
        eventDriver.unregister(eventListener);
    }
    
    public static void getScreenShot() {
        File sFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        sFile.
    }
}
