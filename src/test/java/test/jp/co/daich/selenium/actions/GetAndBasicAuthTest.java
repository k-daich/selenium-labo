/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.actions;

import jp.co.daich.command.GetAndBasicAuth;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class GetAndBasicAuthTest extends TestBase {

    @Override
    public void doTest() {
        GetAndBasicAuth.execute("http://os3-368-17171.vs.sakura.ne.jp:10018/", "daich", "daich0");
    }
}
