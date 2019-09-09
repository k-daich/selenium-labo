/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.command;

import java.text.SimpleDateFormat;
import jp.co.daich.constants.ProjectCommon;
import jp.co.daich.driver.LonelyOnlyDriver;
import jp.co.daich.util.file.FileWriterCustom;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author USER
 */
public class WriteEnviromentTxt {

    private static final String VERSION_STORE_PATH = ProjectCommon.EVI_DIR + "writeVersionTxt_" + ProjectCommon.DATE_TEXT + "version.txt";

    /**
     * Invalidate default Constructor
     */
    private WriteEnviromentTxt() {
    }

    /**
     * version.txtを出力する
     */
    public static void write() {
        FileWriterCustom.write(
                VERSION_STORE_PATH,
                getEnviromentInfo(LonelyOnlyDriver.getDriver()));
    }

    /**
     * バージョン情報
     *
     * @param driver
     * @return
     */
    private static String getEnviromentInfo(WebDriver driver) {
        //ドライバのcapability情報を取得
        Capabilities capabilities = ((RemoteWebDriver) LonelyOnlyDriver.getDriver()).getCapabilities();

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Date    : ").append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(ProjectCommon.TEST_DATE)).append("\n");
        strBuilder.append("HostOS  : ").append(System.getProperty("os.name")).append("\n");
        strBuilder.append("Browser : ").append(capabilities.getBrowserName()).append("\n");
        strBuilder.append("Version : ").append(capabilities.getVersion()).append("\n");
        return strBuilder.toString();
    }

}
