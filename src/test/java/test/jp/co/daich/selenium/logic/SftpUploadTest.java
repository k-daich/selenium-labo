package test.jp.co.daich.selenium.logic;

import java.util.Date;
import jp.co.daich.constants.ProjectCommon;
import jp.co.daich.util.logger.MyLogger;
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
        final String hostname = "XXX.XXX.XXX.XXX";
        final String user = "jboss";
        final String passwd = "xxxxxxxxxxxxxxxxxxx";
        final String fileName = "test2.txt";
        final String uploadFilePath = ProjectCommon.EVI_DIR + "sftpUpload_sample\\" + fileName;
        final String puttingRootPath = "/var/unyo/work/sftp.upload.d/" + fileName;

        Date startTime = new Date();

        // ダウンロードを実施
        new SftpUploader(uploadFilePath, puttingRootPath).communicate(hostname, user, passwd);

        Date endTime = new Date();
        MyLogger.printInfo("アップロード時間(ミリ秒) : " + (endTime.getTime() - startTime.getTime()));

    }

}
