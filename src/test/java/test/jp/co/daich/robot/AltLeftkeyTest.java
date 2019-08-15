/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.robot;

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
public class AltLeftkeyTest {

    private WebDriver driver;

    public AltLeftkeyTest() {
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
        driver.get("http://vermeer.hatenablog.jp/entry/2018/05/30/171915");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void doTest() {
        try {
            long waitTime = 3000;

            // Alt + ←  
            Action.keyPress(KeyEvent.VK_ALT);
            Action.keyPress(KeyEvent.VK_LEFT);

            // Alt + ←   is now pressed 
            Action.keyRelease(KeyEvent.VK_LEFT);
            Action.keyRelease(KeyEvent.VK_ALT);

            Thread.sleep(waitTime);

            // Alt + ←  
            Action.keyPress(KeyEvent.VK_ALT);
            Action.keyPress(KeyEvent.VK_RIGHT);

            // Alt + ←   is now pressed 
            Action.keyRelease(KeyEvent.VK_RIGHT);
            Action.keyRelease(KeyEvent.VK_ALT);

            Thread.sleep(waitTime);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}
