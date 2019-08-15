/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.robot;

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
public class WheelkeyTest {

    private WebDriver driver;

    public WheelkeyTest() {
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
        driver.get("https://docs.oracle.com/javase/jp/7/api/java/awt/Robot.html");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void doTest() {
        try {
            long waitTime = 1000;

            for (int i = 0; i < 10; i++) {
                // wheel 3 degrees
                Action.mouseWheel(3);
                Thread.sleep(waitTime);
            }

            for (int i = 0; i < 10; i++) {
                // wheel 3 degrees
                Action.mouseWheel(-3);
                Thread.sleep(waitTime);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}
