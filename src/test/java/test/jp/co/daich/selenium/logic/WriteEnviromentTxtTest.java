/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.logic;

import jp.co.daich.command.WriteEnviromentTxt;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class WriteEnviromentTxtTest extends TestBase {

    /**
     * Invalidate default Constructor
     */
    public WriteEnviromentTxtTest() {
    }

    @Test
    @Override
    public void doTest() {
        WriteEnviromentTxt.write();
    }

}
