/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.actions;

import jp.co.daich.driver.LonelyMyDriver;
import jp.co.daich.driver.develop.util.WebElementParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class PrintXpathTest extends TestBase {
    @Override
    public void doTest() {
        //検索ボタンの要素をname属性名から取得
        WebElement element = LonelyMyDriver.operate().findElement(By.linkText("セレクトタグに含まれるオプションを取得する"));

        WebElementParser.getTagHierarchy(element);
    }
}
