package test.jp.co.daich.selenium.logic;

import jp.co.daich.constants.ProjectCommon;
import jp.co.daich.util.file.FileWriterCustom;
import jp.co.daich.util.file.FolderFactory;
import jp.co.daich.util.sftp.SftpChmod;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class SftpChmodTest extends TestBase {

    public SftpChmodTest() {
    }

    @Test
    @Override
    public void doTest() {
        final String hostname = "XXX.XXX.XXX.XXX";
        final String user = "jboss";
        final String passwd = "xxxxxxxxxxxxxxxxxxx";
        final String fileName = "test2.txt";
        final String chmodTargetFilePath = "/var/unyo/work/sftp.upload.d/" + fileName;
        final String puttingRootPath = ProjectCommon.EVI_DIR + "sftpChmod" + ProjectCommon.DATE_TEXT;
        final String permissions = "666";

        // エビデンスフォルダを作成する
        FolderFactory.mkdir(puttingRootPath);

        SftpChmod sftpChmod = new SftpChmod(
                Integer.parseInt(permissions, 8),
                chmodTargetFilePath);

        sftpChmod.communicate(hostname, user, passwd);

        FileWriterCustom.write(puttingRootPath + "\\result.txt", sftpChmod.getResult());
    }

}
