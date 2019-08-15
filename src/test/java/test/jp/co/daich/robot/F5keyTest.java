/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import jp.co.daich.robot.Action;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author USER
 */
public class F5keyTest {

    private WebDriver driver;

    public F5keyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // ChromeDriverまでのパスを設定する
        System.setProperty("webdriver.chrome.driver", "src/test/java/jp/co/webdrivers/chromedriver.76.exe");
        driver = new ChromeDriver();
        driver.get("https://caniuse.com/");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void doTest() {
        try {
            long waitTime = 3000;
            Robot robot = new Robot();

            for (int i = 0; i < 5; i++) {
                // ctrl + F5  
                Action.keyPress(KeyEvent.VK_F5);

                // CTRL+F5 is now pressed 
                Action.keyRelease(KeyEvent.VK_F5);

                Thread.sleep(waitTime);
            }

        } catch (InterruptedException | AWTException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}
