/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver;

import jp.co.daich.driver.builder.ChromeDriverSet;
import jp.co.daich.driver.builder.DriverBuilder;

/**
 *
 * @author USER
 */
public class LonelyMyDriver {

    private static final Operatable myDriver;

    static {
        myDriver = new DriverBuilder(new ChromeDriverSet()).build();
    }

    public static Operatable operate() {
        return myDriver;
    }

}
