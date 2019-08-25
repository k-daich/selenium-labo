/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.constants;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Keys;

/**
 *
 * @author USER
 */
public class KeysMap {

    /**
     * Invalidate Constructor
     */
    private KeysMap() {
    }

    /**
     * キー名に対応するKeyEvent数値を返す
     *
     * @param keyName
     * @return Keys
     */
    public static Keys getKeys(String keyName) {
        return INSTANCE.get(keyName);
    }

    /**
     * キー名文字列とKeyEvent数値のマッピング
     */
    private static final Map<String, Keys> INSTANCE = new HashMap<String, Keys>() {
        {
            put(Keys.NULL.name(), Keys.NULL);
            put(Keys.CANCEL.name(), Keys.CANCEL);
            put(Keys.HELP.name(), Keys.HELP);
            put(Keys.BACK_SPACE.name(), Keys.BACK_SPACE);
            put(Keys.TAB.name(), Keys.TAB);
            put(Keys.CLEAR.name(), Keys.CLEAR);
            put(Keys.RETURN.name(), Keys.RETURN);
            put(Keys.ENTER.name(), Keys.ENTER);
            put(Keys.SHIFT.name(), Keys.SHIFT);
            put(Keys.LEFT_SHIFT.name(), Keys.LEFT_SHIFT);
            put(Keys.CONTROL.name(), Keys.CONTROL);
            put(Keys.LEFT_CONTROL.name(), Keys.LEFT_CONTROL);
            put(Keys.ALT.name(), Keys.ALT);
            put(Keys.LEFT_ALT.name(), Keys.LEFT_ALT);
            put(Keys.PAUSE.name(), Keys.PAUSE);
            put(Keys.ESCAPE.name(), Keys.ESCAPE);
            put(Keys.SPACE.name(), Keys.SPACE);
            put(Keys.PAGE_UP.name(), Keys.PAGE_UP);
            put(Keys.PAGE_DOWN.name(), Keys.PAGE_DOWN);
            put(Keys.END.name(), Keys.END);
            put(Keys.HOME.name(), Keys.HOME);
            put(Keys.LEFT.name(), Keys.LEFT);
            put(Keys.ARROW_LEFT.name(), Keys.ARROW_LEFT);
            put(Keys.UP.name(), Keys.UP);
            put(Keys.ARROW_UP.name(), Keys.ARROW_UP);
            put(Keys.RIGHT.name(), Keys.RIGHT);
            put(Keys.ARROW_RIGHT.name(), Keys.ARROW_RIGHT);
            put(Keys.DOWN.name(), Keys.DOWN);
            put(Keys.ARROW_DOWN.name(), Keys.ARROW_DOWN);
            put(Keys.INSERT.name(), Keys.INSERT);
            put(Keys.DELETE.name(), Keys.DELETE);
            put(Keys.SEMICOLON.name(), Keys.SEMICOLON);
            put(Keys.EQUALS.name(), Keys.EQUALS);
            put(Keys.NUMPAD0.name(), Keys.NUMPAD0);
            put(Keys.NUMPAD1.name(), Keys.NUMPAD1);
            put(Keys.NUMPAD2.name(), Keys.NUMPAD2);
            put(Keys.NUMPAD3.name(), Keys.NUMPAD3);
            put(Keys.NUMPAD4.name(), Keys.NUMPAD4);
            put(Keys.NUMPAD5.name(), Keys.NUMPAD5);
            put(Keys.NUMPAD6.name(), Keys.NUMPAD6);
            put(Keys.NUMPAD7.name(), Keys.NUMPAD7);
            put(Keys.NUMPAD8.name(), Keys.NUMPAD8);
            put(Keys.NUMPAD9.name(), Keys.NUMPAD9);
            put(Keys.MULTIPLY.name(), Keys.MULTIPLY);
            put(Keys.ADD.name(), Keys.ADD);
            put(Keys.SEPARATOR.name(), Keys.SEPARATOR);
            put(Keys.SUBTRACT.name(), Keys.SUBTRACT);
            put(Keys.DECIMAL.name(), Keys.DECIMAL);
            put(Keys.DIVIDE.name(), Keys.DIVIDE);
            put(Keys.F1.name(), Keys.F1);
            put(Keys.F2.name(), Keys.F2);
            put(Keys.F3.name(), Keys.F3);
            put(Keys.F4.name(), Keys.F4);
            put(Keys.F5.name(), Keys.F5);
            put(Keys.F6.name(), Keys.F6);
            put(Keys.F7.name(), Keys.F7);
            put(Keys.F8.name(), Keys.F8);
            put(Keys.F9.name(), Keys.F9);
            put(Keys.F10.name(), Keys.F10);
            put(Keys.F11.name(), Keys.F11);
            put(Keys.F12.name(), Keys.F12);
            put(Keys.META.name(), Keys.META);
            put(Keys.COMMAND.name(), Keys.COMMAND);
            put(Keys.ZENKAKU_HANKAKU.name(), Keys.ZENKAKU_HANKAKU);
        }
    };
}
