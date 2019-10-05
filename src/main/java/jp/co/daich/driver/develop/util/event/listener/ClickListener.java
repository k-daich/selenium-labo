package jp.co.daich.driver.develop.util.event.listener;

import jp.co.daich.driver.develop.util.WebElementParser;
import jp.co.daich.driver.develop.util.xpath.candidate.FullPath;
import jp.co.daich.driver.develop.util.xpath.candidate.base.CandidateBase;
import jp.co.daich.util.logger.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 *
 * @author USER
 */
public class ClickListener extends AbstractWebDriverEventListener {

    private static String xpath = null;

    @Override
    //要素をクリックする直前の処理
    public void beforeClickOn(WebElement element, WebDriver driver) {
        MyLogger.printInfo("beforeClickOn:" + element.getTagName());
        CandidateBase candidate = new FullPath();
        xpath = candidate.getXpaths(WebElementParser.getTagHierarchy(element)).get(0);
    }

    @Override
    //要素をクリックした直後の処理
    public void afterClickOn(WebElement element, WebDriver driver) {
//        MyLogger.printInfo("afterClickOn:" + element.getTagName());
    }

    /**
     * クリックされた要素のXpathを返す
     *
     * @return xpath
     */
    public String getClickedXpath() {
        return xpath;
    }
}
