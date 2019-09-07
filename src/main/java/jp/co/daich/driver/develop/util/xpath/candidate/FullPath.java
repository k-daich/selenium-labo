/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.develop.util.xpath.candidate;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import jp.co.daich.constants.properNoun.XML;
import jp.co.daich.driver.LonelyOnlyDriver;
import jp.co.daich.driver.develop.util.xpath.candidate.base.CandidateBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author USER
 */
public class FullPath extends CandidateBase {

    /**
     * Constructor
     */
    public FullPath() {
        super();
    }

    /**
     *
     * @param tagHierarchy
     * @return
     */
    @Override
    protected List<String> searchXpathCandidates(Deque<WebElement> tagHierarchy) {
        StringBuilder xpath = new StringBuilder(128);

        for (WebElement tag : tagHierarchy) {

            // 先頭xpath要素の場合
            if (xpath.length() == 0) {
                xpath.append(XML.XpathSelector.DESCENDANT_NODE.getSelector());
            } // 非先頭xpath要素の場合
            else {
                xpath.append(XML.XpathSelector.CHILD_NODE.getSelector());
            }
            // 要素名を設定
            xpath.append(tag.getTagName());

            // id属性がある場合
            if (StringUtils.isNotEmpty(tag.getAttribute(XML.Attribute.ID.getName()))) {
                // id属性指定を行うxpathを追加する
                xpath = appendAttributeSelector(
                        xpath,
                        XML.Attribute.ID.getName(),
                        tag.getAttribute(XML.Attribute.ID.getName()));
            }

            // name属性がある場合
            if (StringUtils.isNotEmpty(tag.getAttribute(XML.Attribute.NAME.getName()))) {
                // name属性指定を行うxpathを追加する
                xpath = appendAttributeSelector(
                        xpath,
                        XML.Attribute.NAME.getName(),
                        tag.getAttribute(XML.Attribute.NAME.getName()));
            }
        }
        // FullPathするxpathのみをリストに格納して返す
        return Arrays.asList(xpath.toString());
    }

    /**
     *
     * @param xpath
     * @param attrName
     * @param attrValue
     * @return
     */
    private StringBuilder appendAttributeSelector(StringBuilder xpath, String attrName, String attrValue) {
        return xpath.append(XML.XpathSelector.ATTRIBUTE_PREFIX.getSelector())
        .append(attrName)
        .append(XML.XpathSelector.ATTRIBUTE_INFIX.getSelector())
        .append(attrValue)
        .append(XML.XpathSelector.ATTRIBUTE_SUFFIX.getSelector());
    }

    /**
     *
     * @param xpath
     * @return
     */
    @Override
    protected boolean isQualified(String xpath) {
        WebElement element = LonelyOnlyDriver.findElement(By.xpath(xpath));

        // FullPath指定の場合は必ず採用する
        return true;
    }

}
