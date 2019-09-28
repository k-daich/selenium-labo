/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.javascript;

import java.util.Deque;
import jp.co.daich.driver.develop.util.WebElementParser;
import org.openqa.selenium.WebElement;

/**
 *
 * @author USER
 */
public class Element {
    
    public static String getElementJsCode(WebElement ele) {
        StringBuilder code = new StringBuilder("document.");
        Deque<WebElement> eleStack = WebElementParser.getTagHierarchy(ele);
        
//        for (WebElement e : eleStack) {
//            code.append("getElementsByTagName(" + e.getTagName() + ")[" + e.)
//        }
        
        return code.toString();
    }
}
