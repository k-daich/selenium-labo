/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.develop.util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import jp.co.daich.util.logger.Logger;
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
            Logger.printInfo("print by TagName : " + _we.getTagName());
            Logger.printInfo("print by Attribute id : " + _we.getAttribute("id"));
            Logger.printInfo("print by Attribute name : " + _we.getAttribute("name"));
            Logger.printInfo("print by Attribute class : " + _we.getAttribute("class"));
        });
        return _tagStack;
    }
}
