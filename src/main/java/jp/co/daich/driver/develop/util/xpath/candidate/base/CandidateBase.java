/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.develop.util.xpath.candidate.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.openqa.selenium.WebElement;

/**
 *
 * @author USER
 */
abstract public class CandidateBase {

    /**
     * Constructor
     */
    protected CandidateBase() {
    }

    /**
     *
     * @param tagHierarchy s * @return
     * @return 
     */
    public List<String> getXpaths(Deque<WebElement> tagHierarchy) {
        List<String> qualifiedXpath = new ArrayList<>();

        // xpathの候補を取得
        List<String> candidates = searchXpathCandidates(tagHierarchy);

        // 取得したxpathが候補として相応しいか判定
        for (String candidate : candidates) {
            if (isQualified(candidate)) {
                qualifiedXpath.add(candidate);
            }
        }
        return qualifiedXpath;
    }

    /**
     *
     * @param tagHierarchy
     * @return
     */
    protected abstract List<String> searchXpathCandidates(Deque<WebElement> tagHierarchy);

    /**
     *
     * @param xpath
     * @return
     */
    protected abstract boolean isQualified(String xpath);

}
