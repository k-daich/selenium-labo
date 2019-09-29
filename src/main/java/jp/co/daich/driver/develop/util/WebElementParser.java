/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.develop.util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import jp.co.daich.driver.LonelyOnlyDriver;
import jp.co.daich.driver.develop.util.xpath.bean.WebElementInfo;
import jp.co.daich.util.logger.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author USER
 */
public class WebElementParser {

    public static Deque<WebElement> getTagHierarchy(WebElement wEle) {
        List<String> candidates = null;
        Deque<WebElement> _tagStack = new ArrayDeque<>();

        // Loop : 親タグがhtmlタグに到達するまで
        for (; !wEle.getTagName().equalsIgnoreCase("html");) {
            // スタックにタグ名を格納
            _tagStack.addFirst(wEle);
            // 親タグへ移動
            wEle = wEle.findElement(By.xpath(".."));
        }
        // スタックに格納した内容をデバッグ出力
        _tagStack.forEach((WebElement _we ) -> {
            MyLogger.printInfo("print by TagName : " + _we.getTagName());
            MyLogger.printInfo("print by Attribute id : " + _we.getAttribute("id"));
            MyLogger.printInfo("print by Attribute name : " + _we.getAttribute("name"));
            MyLogger.printInfo("print by Attribute class : " + _we.getAttribute("class"));
        });
        return _tagStack;
    }

    /**
     * ルート要素からタグ名検索で何番目に指定要素が存在するかを返す
     * @param wEle
     * @return 何番目か
     */
    public static int getIndexOfByTagNameFromRoot(WebElement wEle) {
        int nth;
        WebElement rootEle = LonelyOnlyDriver.findElement(By.xpath("/html"));
        List<WebElement> candidates = rootEle.findElements(By.tagName(wEle.getTagName()));
        
        for (WebElement candidate : candidates) {
            if (candidate.equals(wEle)) {
                // 何番目だったかを返す
                return candidates.indexOf(candidate);
            }
        }
        throw new RuntimeException("指定した要素タグ名がこのHTML上に存在しません\n" + 
                "タグ名：" + wEle.getTagName());
    }

}

