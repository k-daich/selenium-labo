/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.command;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.daich.seanario.finder.ExcelFinder;
import jp.co.daich.util.logger.Logger;
import jp.co.daich.seanario.reader.ExcelSeanarioReader;

/**
 *
 * @author USER
 */
public class GetSenarioList {

    /**
     * invalidate default Constructor
     */
    private GetSenarioList() {
        // none
    }

    public static Map<String, List<String>> execute(String baseDir) {
        Map<String, List<String>> excelBooks = new HashMap<>();
        List<File> files = ExcelFinder.find(baseDir);

        // ブック単位に繰り返す
        files.forEach((file) -> {
            Logger.printInfo("file Name : " + file.getName());
            excelBooks.put(file.getName(), ExcelSeanarioReader.read(file));
            // シート単位に繰り返す
            ExcelSeanarioReader.read(file).forEach((sheetName) -> {
                Logger.printInfo("sheet Names : " + sheetName);
            });
        });

        return excelBooks;
    }
}
