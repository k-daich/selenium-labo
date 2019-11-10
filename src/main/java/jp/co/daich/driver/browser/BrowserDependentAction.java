/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.browser;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author USER
 */
public interface BrowserDependentAction {

    /**
     * take screen shot
     * @param driver
     * @param imgStorePath
     */
    public void getScreenShot(WebDriver driver, String imgStorePath);
}
