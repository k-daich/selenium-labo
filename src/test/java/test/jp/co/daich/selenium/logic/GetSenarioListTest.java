/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.logic;

import jp.co.daich.command.GetSenarioList;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class GetSenarioListTest extends TestBase {
    
    public GetSenarioListTest() {
    }

    @Test
    @Override
    public void doTest() {
        GetSenarioList.execute("C:\\netbeans\\projects\\fg-bookie\\designDoc\\01_DB設計\\entity");
    }
}
