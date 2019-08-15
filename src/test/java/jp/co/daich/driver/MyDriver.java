/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author USER
 */
public class MyDriver {

    private static final WebDriver driver;
    protected static final Actions acts;

    static {
        // ChromeDriverまでのパスを設定する
        System.setProperty("webdriver.chrome.driver", "src/test/java/jp/co/webdrivers/chromedriver.76.exe");
        driver = new ChromeDriver();
        driver.get("https://www.seleniumqref.com/api/java/element_infoget/Java_getLocation.html");

        acts = new Actions(driver);
    }

    /**
     * 指定(By)した要素を返す
     * @param by
     * @return 要素
     */
    public static WebElement findElement(By by) {
        return driver.findElement(by);
    }
}
