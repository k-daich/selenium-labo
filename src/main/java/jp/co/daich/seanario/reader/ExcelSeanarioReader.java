/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.seanario.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author USER
 */
public class ExcelSeanarioReader {

    public static List<String> read(File file) {
        List<String> bookList = new ArrayList<>();
        Workbook workbook = null;

        try {
            // java.io.Fileから
            workbook = WorkbookFactory.create(new FileInputStream(file));
        } catch (IOException | EncryptedDocumentException ex) {
            throw new RuntimeException("Excelの読み込み失敗：" + file.getName() + "\n" + ex);
        }

        return getSheetNames(workbook);
    }

    /**
     * 1ブック内のリスト一覧を取得
     *
     * @param workbook
     * @return
     */
    private static List<String> getSheetNames(Workbook workbook) {
        // シート名一覧リスト(初期化)
        List<String> sheetList = new ArrayList<>();

        Iterator<Sheet> itr = workbook.iterator();

        // シートがあるだけ繰り返し
        while (itr.hasNext()) {
            // シート名を一覧に追加する
            sheetList.add(itr.next().getSheetName());
        }
        return sheetList;
    }
}
