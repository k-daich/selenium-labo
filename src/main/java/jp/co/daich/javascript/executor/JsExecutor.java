/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.javascript.executor;

import jp.co.daich.driver.LonelyMyDriver;
import org.openqa.selenium.JavascriptExecutor;

/**
 *
 * @author USER
 */
public abstract class JsExecutor {

    /**
     * Constructor
     */
    protected JsExecutor() {
    }

    /**
     * precheck driver applied JavascriptExecutor 
     *  and do main process
     */
    public void run() {
        JavascriptExecutor jsExe = null;

        // WebDriverがJavascriptExecutorの親クラスかチェックする
        if (LonelyMyDriver.operate() instanceof JavascriptExecutor) {
            jsExe = (JavascriptExecutor) LonelyMyDriver.operate();
        } else {
            throw new RuntimeException("this driver is not applied JavascriptExecutor");
        }
        jsExe.executeScript(getScript(), getArgs());
    }

    /**
     *  to do Implement
     * @return script
     */
    abstract protected String getScript();

    /**
     * to do Implement
     * @return args
     */
    abstract protected Object[] getArgs();

}
