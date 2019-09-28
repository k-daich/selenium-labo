package jp.co.daich.driver.develop.util.xpath.bean;

import org.openqa.selenium.WebElement;

/**
 *
 * @author USER
 */
public class WebElementInfo {
    // 同名タグ内で何番目か
    private final int indexOfSameNameTags;
    private final WebElement element;

    public WebElementInfo(int indexOfSameNameTags, WebElement element ) {
        this.indexOfSameNameTags = indexOfSameNameTags;
        this.element = element;
    }

    /**
     * @return the indexOfSameNameTags
     */
    public int getIndexOfSameNameTags() {
        return indexOfSameNameTags;
    }

    /**
     * @return the element
     */
    public WebElement getElement() {
        return element;
    }
}
