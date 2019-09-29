/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.logic;

import java.util.Date;
import jp.co.daich.constants.ProjectCommon;
import jp.co.daich.util.file.FolderFactory;
import jp.co.daich.util.logger.MyLogger;
import jp.co.daich.util.sftp.SftpDownloader;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class SftpDownloadTest extends TestBase {

    public SftpDownloadTest() {
    }

    @Test
    @Override
    public void doTest() {
        final String hostname = "XXX.XXX.XXX.XXX";
        final String user = "jboss";
        final String passwd = "xxxxxxxxxxxxxxxxxxx";
        final String targetRootPath = "/var/unyo/work/sftp.download.d/";
        final String puttingRootPath = ProjectCommon.EVI_DIR + "sftpDownload" + ProjectCommon.DATE_TEXT;

        // エビデンスフォルダを作成する
        FolderFactory.mkdir(puttingRootPath);

        Date startTime = new Date();

        // ダウンロードを実施
        new SftpDownloader(targetRootPath, puttingRootPath).communicate(hostname, user, passwd);

        Date endTime = new Date();
        MyLogger.printInfo("ダウンロード時間(ミリ秒) : " + (endTime.getTime() - startTime.getTime()));

    }

}
