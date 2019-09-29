/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.develop.util.event.listener;

import jp.co.daich.util.logger.MyLogger;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 *
 * @author USER
 */
public class LoadNewPageListener extends AbstractWebDriverEventListener {

    private String gotUrl = StringUtils.EMPTY;

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        MyLogger.printInfo("print by beforeGotURL : " + url);
        gotUrl = url;
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        MyLogger.printInfo("print by gotURL : " + url);
        gotUrl = url;
    }

    /**
     *
     * @return
     */
    public String getCurrentUrl() {
        return gotUrl;
    }
}
