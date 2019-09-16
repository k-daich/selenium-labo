/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.logic;

import java.util.Date;
import jp.co.daich.constants.ProjectCommon;
import jp.co.daich.util.file.FolderFactory;
import jp.co.daich.util.logger.Logger;
import jp.co.daich.util.sftp.SftpUploader;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class SftpUploadTest extends TestBase {

    public SftpUploadTest() {
    }

    @Test
    @Override
    public void doTest() {
        final String hostname = "133.167.76.175";
        final String user = "jboss";
        final String passwd = "0GchCsumGutS";
        final String uploadFilePath = ProjectCommon.EVI_DIR + "sftpUpload_sample\\test.txt";
        final String puttingRootPath = "/var/unyo/work/sftp.upload.d/";

        Date startTime = new Date();

        // ダウンロードを実施
        new SftpUploader(uploadFilePath, puttingRootPath).communicate(hostname, user, passwd);

        Date endTime = new Date();
        Logger.printInfo("アップロード時間(ミリ秒) : " + (endTime.getTime() - startTime.getTime()));

    }

}
