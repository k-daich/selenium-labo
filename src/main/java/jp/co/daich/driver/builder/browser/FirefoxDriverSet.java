package jp.co.daich.driver.builder.browser;

import jp.co.daich.constants.properNoun.Browser;
import jp.co.daich.driver.MyDriver;
import jp.co.daich.driver.browser.FirefoxAction;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
     * @param options
     * @return webDriver
     */
    @Override
    public WebDriver createWebDriver(Capabilities options) {
        return new FirefoxDriver(options);
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
    public Capabilities setDriverProperty() {
        System.setProperty("webdriver.gecko.driver", "src/main/java/jp/co/webdrivers/geckodriver0.26.0.exe");
        FirefoxOptions options = new FirefoxOptions();
        return (Capabilities)options;
    }

}
