/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.seanario.finder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.daich.util.properNoun.FileLogic;
import jp.co.daich.driver.develop.util.logger.Logger;

/**
 *
 * @author USER
 */
public class ExcelFinder {

    /**
     * Invelidate default Constructor
     */
    private ExcelFinder() {
        // none
    }

    /**
     *
     * @param baseDir
     * @return
     */
    public static List<File> find(String baseDir) {
        List<File> excelFileList = new ArrayList<>();
        File dir = new File(baseDir);
        File[] files = dir.listFiles();

        for (File file : files) {
            Logger.printSevere("find FileName :" + file.getName());
            // ファイルであるか、かつエクセルファイルであるか
            if (file.isFile()
                    && FileLogic.isExcel(file)) {
                Logger.printSevere("〇 it is Excel File :" + file.getName());
                // エクセルファイルであればファイル一覧に追加する
                excelFileList.add(file);
            }
            else {
                Logger.printSevere("× it is not Excel File :" + file.getName());
            }
        }
        return excelFileList;
    }

}
