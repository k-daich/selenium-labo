package test.jp.co.daich.selenium.logic;

import java.util.List;
import java.util.Map;
import jp.co.daich.command.GetSenarioList;
import jp.co.daich.constants.ProjectCommon;
import jp.co.daich.constants.properNoun.WINDOWS;
import jp.co.daich.util.file.FileWriterCustom;
import jp.co.daich.util.file.FolderFactory;
import jp.co.daich.util.logger.MyLogger;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class GetSenarioListTest extends TestBase {

    public GetSenarioListTest() {
    }

    @Test
    @Override
    public void doTest() {
        final String puttingRootPath = ProjectCommon.EVI_DIR + "getSenarioList" + ProjectCommon.DATE_TEXT;
        StringBuilder sBuilder = new StringBuilder();
        int listIndex = 1;
        // エビデンスフォルダを作成する
        FolderFactory.mkdir(puttingRootPath);

        Map<String, List<String>> excelBooks = GetSenarioList.execute("C:\\netbeans\\projects\\fg-bookie\\designDoc\\01_DB設計\\entity");
        // ブック単位に繰り返し
        for (String bookName : excelBooks.keySet()) {
            MyLogger.printInfo("FileWrite for bookName -> " + bookName);
            sBuilder.append("[Book]  ").append(bookName).append("\n");
            // シート単位に繰り返し
            for (String sheetName : excelBooks.get(bookName)) {
                MyLogger.printInfo("FileWrite for sheetName -> " + bookName);
                sBuilder.append("\t").append(listIndex++).append("\t").append(sheetName).append("\n");
            }
        }

        // シナリオリストをファイルに書き出す
        FileWriterCustom.write(puttingRootPath + WINDOWS.FILE_SEPARATOR + "seanrioList.txt", sBuilder.toString());
    }

}
