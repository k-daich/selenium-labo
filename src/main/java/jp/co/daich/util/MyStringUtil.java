/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util;

import jp.co.daich.constants.properNoun.ObjectConstants;

/**
 *
 * @author USER
 */
public class MyStringUtil {

    /**
     * 空である場合にtrueを返す(nullの場合もtrueを返す)
     * @param value
     * @return isEmpty
     */
    public static boolean isEmpty(String value) {
        return value == null
                || ObjectConstants.EMPTY.equals(value);
    }

    /**
     * 非空である場合にtrueを返す(nullの場合はfalseを返す)
     * @param value
     * @return isEmpty
     */
    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    /**
     * 先頭から指定文字に合致するまでの文字列を返す 例：文字列「abcdef」に対して'c'を指定した場合は「ab」を返す
     *
     * @param src
     * @param subStarChara
     * @return 切り出された文字列
     */
    public static String subString(String src, char subStarChara) {
        int subsStartindex = src.indexOf(subStarChara);
        // 切り出すキーワードに合致しなかった場合は文字列をそのまま返す
        if (subsStartindex == -1) {
            return src;
        }
        return src.substring(1, subsStartindex);
    }
}
