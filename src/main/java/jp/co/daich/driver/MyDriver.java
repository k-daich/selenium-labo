package jp.co.daich.driver;

import jp.co.daich.constants.properNoun.Browser;

/**
 *
 * @author USER
 */
public class MyDriver {
    protected static Browser.TYPE type;

    public boolean isFirefox () {
        return type == Browser.TYPE.FIREFOX;
    }

    public boolean isChrome() {
        return type == Browser.TYPE.CHROME;
    }

    public boolean isIE () {
        return type == Browser.TYPE.IE;
    }

    public boolean isEdge () {
        return type == Browser.TYPE.EDGE;
    }

    public boolean isSafari () {
        return type == Browser.TYPE.SAFARI;
    }

}
