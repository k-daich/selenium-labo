/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.robot;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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
public class CntlFkeyTest {

    private WebDriver driver;

    public CntlFkeyTest() {
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

            // ctrl + F  
            Action.keyPress(KeyEvent.VK_CONTROL);
            Action.keyPress(KeyEvent.VK_F);

            // CTRL+F is now pressed 
            Action.keyRelease(KeyEvent.VK_F);
            Action.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(waitTime);
            String text = "CSS Grid";
            StringSelection stringSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            clipboard.setContents(stringSelection, stringSelection);

            Action.keyPress(KeyEvent.VK_CONTROL);
            Action.keyPress(KeyEvent.VK_V);
            Action.keyRelease(KeyEvent.VK_V);
            Action.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(waitTime);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}
