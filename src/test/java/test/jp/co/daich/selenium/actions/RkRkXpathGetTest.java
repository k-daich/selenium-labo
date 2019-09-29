/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.actions;

import java.util.List;
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
        List<String> xpaths = rkrkXpathGet.waitClick();

        for (String xpath : xpaths) {
            MyLogger.printInfo("result of RkRkXpathGet : " + xpath);
        }
    }
}
