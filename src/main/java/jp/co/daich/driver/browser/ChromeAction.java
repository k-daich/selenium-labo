/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.browser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import jp.co.daich.constants.properNoun.WINDOWS;
import jp.co.daich.driver.LonelyMyDriver;
import jp.co.daich.manage.evi.EviSeqManager;
import jp.co.daich.util.logger.MyLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author USER
 */
public class ChromeAction implements BrowserDependentAction {

    /**
     * スクロールで位置が変わらなくなるまで繰り返しスクリーンショットを保存する
     *
     * @param imgStorePath
     */
    @Override
    public void getScreenShot(WebDriver driver, String imgStorePath) {
        // 直近ブラウザ表示のY位置 ※初期値を-1にすることで初回のisScrolledをtrueにしている
        long latestViewTopHeight = -1;
        long nowViewTopHeight = 0;

        // ブラウザY座標が高くなり続ける間はスクリーンショットを保存する
        while (nowViewTopHeight > latestViewTopHeight) {
            takeCapture(driver, imgStorePath);
            latestViewTopHeight = nowViewTopHeight;
            // ウィンドウ高さ分だけスクロール
            nowViewTopHeight = scroll(driver);
        }
    }

    /**
     *
     * @param driver
     * @param imgStorePath
     */
    private void takeCapture(WebDriver driver, String imgStorePath) {

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

    /**
     * ブラウザの高さ文だけスクロールする
     *
     * @param driver
     * @return スクロール後の高さ
     */
    private long scroll(WebDriver driver) {
        // scrollByの第一引数：x座標の移動距離
        // scrollByの第二引数：y座標の移動距離
        LonelyMyDriver.operate().executeJavaScript("scrollBy (0 , "
                + LonelyMyDriver.operate().executeJavaScript("return window.innerHeight")
                + ")");
        return ((Number) LonelyMyDriver.operate().executeJavaScript("return window.pageYOffset")).longValue();
    }
}
