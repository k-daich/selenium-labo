/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.robot;

import jp.co.daich.driver.MyDriver;
import jp.co.daich.driver.actions.MyActions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author USER
 */
public class MoveMouseCursorTest {

    public MoveMouseCursorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void doTest() {
        //検索ボタンの要素をname属性名から取得
        WebElement element = MyDriver.findElement(By.linkText("トップページ"));
        MyActions.moveCursorToElement(element);
        MyActions.wait(5000);
        MyActions.mouseClick();
        MyActions.wait(5000);
    }
}
