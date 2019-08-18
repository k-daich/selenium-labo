/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.develop.util;

/**
 *
 * @author USER
 */
public class ThreadUtil {

    /**
     * 待機する
     *
     * @param millTime ミリ秒
     */
    public static void sleep(long millTime) {
        try {
            Thread.sleep(millTime);
        } catch (InterruptedException e) {
            // マルチスレッド処理内でなければ発生しえないため握りつぶす
        }
    }
}
