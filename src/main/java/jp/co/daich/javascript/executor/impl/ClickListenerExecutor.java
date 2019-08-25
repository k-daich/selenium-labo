/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.javascript.executor.impl;

import jp.co.daich.javascript.executor.JsExecutor;

/**
 *
 * @author USER
 */
public class ClickListenerExecutor extends JsExecutor {

    @Override
    protected String getScript() {
        return "var body = document.getElementsByTagName('body');\n"
                + "document.body.onclick = function ('click', function (event) {\n"
                + "    console.log(event.target);\n"
                + "});\n";
    }

    @Override
    protected Object[] getArgs() {
        return new Object[]{};
    }
}
