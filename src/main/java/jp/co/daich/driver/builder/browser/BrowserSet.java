package jp.co.daich.driver.builder.browser;

import jp.co.daich.driver.MyDriver;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author USER
 */
public interface BrowserSet {

    /**
     * @return webDriver
     */
    WebDriver createWebDriver();

    /**
     * set Action per Browser
     * @param driver
     */
    void setBrowserAction(MyDriver driver);

    /**
     * set Browser type
     * @param driver
     */
    void setBrowserType(MyDriver driver);

    /**
     * set Property per Browser
     */
    void setDriverProperty();

}
