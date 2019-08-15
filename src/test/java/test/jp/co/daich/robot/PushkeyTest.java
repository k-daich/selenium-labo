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
public class PushkeyTest {

    private WebDriver driver;

    public PushkeyTest() {
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
            for (int i : new int[]{0, 1, 2}) {
                long waitTime = 2000;
                Action.pressAndReleaseMultipleKeys(KeyEvent.VK_ALT, KeyEvent.VK_LEFT);
                Thread.sleep(waitTime);
                Action.pressAndReleaseMultipleKeys(KeyEvent.VK_ALT, KeyEvent.VK_RIGHT);
                Thread.sleep(waitTime);
                Action.pressAndReleaseMultipleKeys(KeyEvent.VK_CONTROL, KeyEvent.VK_F);
                Thread.sleep(waitTime);
                Action.pressAndReleaseMultipleKeys(KeyEvent.VK_ESCAPE);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
