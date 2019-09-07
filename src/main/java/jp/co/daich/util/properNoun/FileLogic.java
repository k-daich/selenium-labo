/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.properNoun;

import java.io.File;
import jp.co.daich.constants.properNoun.FileConstants;

/**
 *
 * @author USER
 */
public class FileLogic {

    /**
     * Invelidate default Logic
     */
    private FileLogic() {
        // none
    }

    /**
     * if ExcelFile Extension is excel , return true.
     *
     * @param file
     * @return isExcelFileExtension
     */
    public static boolean isExcel(File file) {
        String fileNameLowerCase = file.getName().toLowerCase();
        return fileNameLowerCase.endsWith(FileConstants.EXTENSION.XLS.getName())
                || fileNameLowerCase.endsWith(FileConstants.EXTENSION.XLSX.getName())
                || fileNameLowerCase.endsWith(FileConstants.EXTENSION.XLSM.getName());
    }
}
