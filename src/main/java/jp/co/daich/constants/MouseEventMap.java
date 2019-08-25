/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.constants;

import java.awt.event.InputEvent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author USER
 */
public class MouseEventMap {

    /**
     * Invalidate Constructor
     */
    private MouseEventMap() {
    }

    /**
     * キー名に対応するKeyEvent数値を返す
     * @param mouseName
     * @return InputEvent.intValue
     */
    public static int getMouseEvent(String mouseName) {
        return INSTANCE.get(mouseName);
    }

    /**
     * マウスイベント文字列とInputEvent数値のマッピング
     */
    private static final Map<String, Integer> INSTANCE = new HashMap<String, Integer>() {
        {
            put("LeftButton", InputEvent.BUTTON1_DOWN_MASK);
            put("RightButton", InputEvent.BUTTON3_DOWN_MASK);
        }
    };

}
