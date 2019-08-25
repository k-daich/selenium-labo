/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.actions;

import java.util.List;
import jp.co.daich.driver.LonlyOnlyDriver;
import jp.co.daich.driver.develop.util.WebElementParser;
import jp.co.daich.driver.develop.util.logger.Logger;
import jp.co.daich.driver.develop.util.xpath.candidate.FullPath;
import jp.co.daich.driver.develop.util.xpath.candidate.base.CandidateBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class XpathCandidateTest extends TestBase {

    @Override
    public void doTest() {
        CandidateBase candidate = new FullPath();

        //検索ボタンの要素をname属性名から取得
        WebElement element = LonlyOnlyDriver.findElement(By.linkText("セレクトタグに含まれるオプションを取得する"));
        List<String> xpaths = candidate.getXpaths(
                WebElementParser.getTagHierarchy(element));

        xpaths.forEach((xpath) -> {
            Logger.printSevere("print by xpath : " + xpath);
        });
    }
}
