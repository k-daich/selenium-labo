/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.develop.util.event.listener;

import jp.co.daich.util.logger.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 *
 * @author USER
 */
public class ClickListener extends AbstractWebDriverEventListener {

    private WebElement clickedWebElement = null;

    @Override
    //要素をクリックする直前の処理
    public void beforeClickOn(WebElement element, WebDriver driver) {
        Logger.printInfo("beforeClickOn:" + element.getTagName());
        clickedWebElement = element;
    }

    @Override
    //要素をクリックした直後の処理
    public void afterClickOn(WebElement element, WebDriver driver) {
        Logger.printInfo("afterClickOn:" + element.getTagName());
    }

    /**
     * クリックされた要素情報を返す
     *
     * @return clickedWebElement
     */
    public WebElement getClickedWebElement() {
        return clickedWebElement;
    }
}
