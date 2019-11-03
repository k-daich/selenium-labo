/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.robot;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import jp.co.daich.command.CtrlFSearch;
import jp.co.daich.robot.RobotAction;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class CntlFkeyTest extends TestBase {

    public CntlFkeyTest() {
    }

    @Test
    @Override
    public void doTest() {
        CtrlFSearch.execute("要素に対して「getLocation」を実行することで要素の(X,Y)座標を取得することが出来ます。");
        CtrlFSearch.execute("対して「getLocation」を実行することで、要素の(X,Y)座標を取得し");
        CtrlFSearch.execute("getLocation・・・要素の(X,Y)座標を取得する");
    }
}
