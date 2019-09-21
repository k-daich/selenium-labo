/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.logic;

import jp.co.daich.constants.ProjectCommon;
import jp.co.daich.util.file.FileWriterCustom;
import jp.co.daich.util.file.FolderFactory;
import jp.co.daich.util.sftp.SftpLs;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class SftpLsTest extends TestBase {

    public SftpLsTest() {
    }

    @Test
    @Override
    public void doTest() {
        final String hostname = "XXX.XXX.XXX.XXX";
        final String user = "jboss";
        final String passwd = "xxxxxxxxxxxxxxxxxxx";
        String lsTargetPath = "/var/unyo/work/sftp.download.d/";
        final String puttingRootPath = ProjectCommon.EVI_DIR + "sftpLs" + ProjectCommon.DATE_TEXT;

        // エビデンスフォルダを作成する
        FolderFactory.mkdir(puttingRootPath);

        SftpLs sftpLs = new SftpLs(lsTargetPath);
        sftpLs.communicate(hostname, user, passwd);

        FileWriterCustom.write(puttingRootPath + "\\result.txt" , sftpLs.getResult());
    }

}
