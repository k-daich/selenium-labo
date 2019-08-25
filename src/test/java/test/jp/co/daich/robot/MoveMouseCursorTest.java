/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.robot;

import jp.co.daich.driver.actions.MyActions;
import org.junit.Test;
import org.openqa.selenium.By;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class MoveMouseCursorTest extends TestBase {

    public MoveMouseCursorTest() {
    }

    @Test
    @Override
    public void doTest() {
        //検索ボタンの要素をname属性名から取得
        MyActions.moveCursorToElement(By.linkText("規約"));
        MyActions.wait(5000);
        MyActions.mouseClick();
        MyActions.wait(5000);
    }
}
