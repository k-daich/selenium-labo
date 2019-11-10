package jp.co.daich.driver.browser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import jp.co.daich.constants.properNoun.WINDOWS;
import jp.co.daich.manage.evi.EviSeqManager;
import jp.co.daich.util.logger.MyLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author USER
 */
public class EdgeAction implements BrowserDependentAction {

    /**
     *
     * @param imgStorePath
     */
    @Override
    public void getScreenShot(WebDriver driver, String imgStorePath) {
        // webdriverで撮った一時スクショファイル
        File sFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        // スクリーンショット出力先
        String outputPath = imgStorePath + WINDOWS.FILE_SEPARATOR + EviSeqManager.getSeq() + "_output.png";

        // 入力/出力ストリーム開始
        try (
                FileInputStream inStream = new FileInputStream(sFile);
                FileOutputStream outStream = new FileOutputStream(outputPath);) {
            int readBytes;
            // 入力ストリームの読み込んだバイト数だけファイルに書き出す
            while ((readBytes = inStream.read()) != -1) {
                outStream.write(readBytes);
            }
            MyLogger.printInfo("store screens shot at : " + outputPath);
        } catch (IOException ex) {
            MyLogger.printInfo(ex.getMessage());
        }
    }

}
