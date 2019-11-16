package jp.co.daich.driver.builder;

import jp.co.daich.driver.MyDriver;
import jp.co.daich.driver.builder.browser.BrowserSet;
import org.openqa.selenium.Capabilities;

/**
 *
 * @author USER
 */
public class DriverBuilder {

    private final BrowserSet browserSet;

    /**
     * This must use Inheritance Class
     * @param browserSet
     */
    public DriverBuilder(BrowserSet browserSet) {
        this.browserSet = browserSet;
    }

    /**
     * @return driver
     */
    public MyDriver build() {
        Capabilities options = browserSet.setDriverProperty();
        MyDriver driver = new MyDriver(browserSet.createWebDriver(options));
        browserSet.setBrowserAction(driver);
        browserSet.setBrowserType(driver);
        driver.setBrowserSize(driver, 512, 768);
        return driver;
    }
}
