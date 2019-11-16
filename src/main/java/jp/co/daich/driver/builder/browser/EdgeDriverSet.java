package jp.co.daich.driver.builder.browser;

import jp.co.daich.constants.properNoun.Browser;
import jp.co.daich.driver.MyDriver;
import jp.co.daich.driver.browser.EdgeAction;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

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
    public WebDriver createWebDriver(Capabilities options) {
        return new EdgeDriver(options);
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
    public Capabilities setDriverProperty() {
        System.setProperty("webdriver.edge.driver", "src/main/java/jp/co/webdrivers/MicrosoftWebDriver.exe");
        EdgeOptions options = new EdgeOptions();
        return (Capabilities) options;
    }

}
