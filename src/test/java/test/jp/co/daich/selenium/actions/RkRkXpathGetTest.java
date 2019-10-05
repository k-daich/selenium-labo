package test.jp.co.daich.selenium.actions;

import jp.co.daich.command.RkRkXpathGet;
import jp.co.daich.util.logger.MyLogger;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class RkRkXpathGetTest extends TestBase {

    @Override
    public void doTest() {
        RkRkXpathGet rkrkXpathGet = new RkRkXpathGet();

        // リスナー開始
        rkrkXpathGet.startListener();
        // クリックされた要素のxpathを取得する
        String xpath = rkrkXpathGet.waitClick();

//        for (String xpath : xpaths) {
            MyLogger.printInfo("result of RkRkXpathGet : " + xpath);
//        }
    }
}
