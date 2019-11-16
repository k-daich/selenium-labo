/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.base;

import jp.co.daich.driver.LonelyMyDriver;
import jp.co.daich.util.logger.MyLogger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author USER
 */
public abstract class TestBase {
    
    /**
     * Constructor
     */
    protected TestBase() {
        // none
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        MyLogger.printInfo("☆☆☆" + this.getClass().getSimpleName() + "☆☆☆");
//        LonelyMyDriver.operate().get("https://caniuse.com/");

        LonelyMyDriver.operate().get("https://www.seleniumqref.com/api/java/element_infoget/Java_getLocation.html");
    }

    @After
    public void tearDown() {
//        LonelyMyDriver.operate().quit();
    }

    @Test
    abstract public void doTest();

}
