/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.builder;

import jp.co.daich.constants.properNoun.Browser;
import jp.co.daich.driver.MyDriver;
import jp.co.daich.driver.browser.EdgeAction;
import jp.co.daich.driver.builder.browser.BrowserSet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 *
 * @author USER
 */
public class EdgeDriverSet implements BrowserSet {

    /**
     * Constractor
     */
    public EdgeDriverSet() {
    }

    /**
     * @return webDriver
     */
    @Override
    public WebDriver createWebDriver() {
        return new EdgeDriver();
    }

    /**
     * set Action per Browser
     */
    @Override
    public void setBrowserAction(MyDriver driver) {
        driver.setBrowserAction(new EdgeAction());
    }

    /**
     * set Browser type
     */
    @Override
    public void setBrowserType(MyDriver driver) {
        driver.setType(Browser.TYPE.EDGE);
    }

    /**
     * set Property per Browser
     */
    @Override
    public void setDriverProperty() {
        System.setProperty("webdriver.edge.driver", "src/main/java/jp/co/webdrivers/MicrosoftWebDriver.exe");
    }

}
