package jp.co.daich.driver.builder;

import java.util.Collections;
import jp.co.daich.constants.properNoun.Browser;
import jp.co.daich.driver.MyDriver;
import jp.co.daich.driver.browser.ChromeAction;
import jp.co.daich.driver.builder.browser.BrowserSet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author USER
 */
public class ChromeDriverSet implements BrowserSet {

    /**
     * Constractor
     */
    public ChromeDriverSet() {
    }

    /**
     * @return webDriver
     */
    @Override
    public WebDriver createWebDriver() {
        return new ChromeDriver();
    }

    /**
     * set Action per Browser
     */
    @Override
    public void setBrowserAction(MyDriver driver) {
        driver.setBrowserAction(new ChromeAction());
    }

    /**
     * set Browser type
     */
    @Override
    public void setBrowserType(MyDriver driver) {
        driver.setType(Browser.TYPE.CHROME);
    }

    /**
     * set Property per Browser
     */
    @Override
    public void setDriverProperty() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        System.setProperty("webdriver.chrome.driver", "src/main/java/jp/co/webdrivers/chromedriver.78.exe");
    }

}
