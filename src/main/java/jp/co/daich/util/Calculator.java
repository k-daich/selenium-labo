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

    /**
     * 掛け算を実施
     * @param x
     * @param y
     * @return 積
     */
    public static int multiply(double x, double y) {

        double result = x * y;

        if (Integer.MAX_VALUE < result) {
            throw new RuntimeException("積の結果がintの最大値超過 result : " + result);
        } else if (result < Integer.MIN_VALUE) {
            throw new RuntimeException("積の結果がintの最小値未満 result : " + result);
        }
        return (int) result;
    }

    /**
     * 割り算を実施
     * @param x
     * @param y
     * @return 商
     */
    public static double divide(double x, double y) {

        double result = x / y;

        if (Double.MAX_VALUE < result) {
            throw new RuntimeException("商の結果がdoubleの最大値超過 result : " + result);
        } else if (result < Double.MIN_VALUE) {
            throw new RuntimeException("商の結果がdoubleの最小値未満 result : " + result);
        }
        return result;
    }

}
