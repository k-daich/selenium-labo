/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util;

/**
 *
 * @author USER
 */
public class Calculator {

    public static int multiply(double x, double y) {

        double result = x * y;

        if (Integer.MAX_VALUE < result) {
            throw new RuntimeException("積の結果がintの最大値超過 result : " + result);
        } else if (result < Integer.MIN_VALUE) {
            throw new RuntimeException("積の結果がintの最小値未満 result : " + result);
        }
        return (int) result;
    }
}
