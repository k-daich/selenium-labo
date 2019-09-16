/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.constants.properNoun;

/**
 *
 * @author USER
 */
public class FileConstants {

    public enum EXTENSION {
        XLS("xls"),
        XLSX("xlsx"),
        XLSM("xlsm");

        private final String name;

        EXTENSION(String name) {
            this.name = name;
        }
        /**
         * return name
         * @return name
         */
        public String getName() {
            return this.name;
        }
    }

}
