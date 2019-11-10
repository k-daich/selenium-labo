/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.builder;

import jp.co.daich.constants.properNoun.Browser;
import jp.co.daich.driver.MyDriver;
import jp.co.daich.driver.browser.FirefoxAction;
import jp.co.daich.driver.builder.browser.BrowserSet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author USER
 */
public class FirefoxDriverSet implements BrowserSet {

    /**
     * Constractor
     */
    public FirefoxDriverSet() {
    }

    /**
     * @return webDriver
     */
    @Override
    public WebDriver createWebDriver() {
        return new FirefoxDriver();
    }

    /**
     * set Action per Browser
     */
    @Override
    public void setBrowserAction(MyDriver driver) {
        driver.setBrowserAction(new FirefoxAction());
    }

    /**
     * set Browser type
     */
    @Override
    public void setBrowserType(MyDriver driver) {
        driver.setType(Browser.TYPE.FIREFOX);
    }

    /**
     * set Property per Browser
     */
    @Override
    public void setDriverProperty() {
        System.setProperty("webdriver.gecko.driver", "src/main/java/jp/co/webdrivers/geckodriver0.26.0.exe");
    }

}
