package jp.co.daich.driver.builder.browser;

import java.util.Collections;
import jp.co.daich.constants.properNoun.Browser;
import jp.co.daich.driver.MyDriver;
import jp.co.daich.driver.browser.ChromeAction;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Proxy;
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
     * @param options
     * @return webDriver
     */
    @Override
    public WebDriver createWebDriver(Capabilities options) {
        return new ChromeDriver(options);
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
    public Capabilities setDriverProperty() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        setProxy(options);
        System.setProperty("webdriver.chrome.driver", "src/main/java/jp/co/webdrivers/chromedriver.78.exe");

        return (Capabilities) options;
    }

    /**
     * 
     * @param options 
     */
    private void setProxy(ChromeOptions options) {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("localhost:3128");
        proxy.setSslProxy("localhost:3128");
        options.setProxy(proxy);
    }
}
