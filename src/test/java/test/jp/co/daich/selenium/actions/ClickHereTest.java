/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.actions;

import jp.co.daich.command.ClickHere;
import jp.co.daich.driver.LonelyOnlyDriver;
import jp.co.daich.driver.actions.MyActions;
import org.junit.Test;
import org.openqa.selenium.By;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class ClickHereTest extends TestBase{

    public ClickHereTest() {
    }

    @Test
    @Override
    public void doTest() {
        ClickHere.execute(By.linkText("トップページ"));
        ClickHere.execute(By.linkText("本サイトについて"));
        ClickHere.execute(By.linkText("Selenium Java(ABC順)"));
    }
}
