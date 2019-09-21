package test.jp.co.daich.selenium.logic;

import java.util.HashMap;
import java.util.Map;
import jp.co.daich.constants.ProjectCommon;
import jp.co.daich.util.file.FileWriterCustom;
import jp.co.daich.util.file.FolderFactory;
import jp.co.daich.util.sftp.SftpChown;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class SftpChownTest extends TestBase {

    public SftpChownTest() {
    }

    @Test
    @Override
    public void doTest() {
        final String hostname = "XXX.XXX.XXX.XXX";
        final String user = "jboss";
        final String passwd = "xxxxxxxxxxxxxxxxxxx";
        final String fileName = "test2.txt";
        final String chownTargetFilePath = "/var/unyo/work/sftp.upload.d/" + fileName;
        final String puttingRootPath = ProjectCommon.EVI_DIR + "sftpChown" + ProjectCommon.DATE_TEXT;
        final String owner = "git";
        final Map<String, Integer> uidMap = new HashMap<String, Integer>() {
            {
                put("apache", 48);
                put("jboss", 500);
                put("git", 501);
            }
        };

        // エビデンスフォルダを作成する
        FolderFactory.mkdir(puttingRootPath);

        SftpChown sftpChown = new SftpChown(
                uidMap.get(owner),
                chownTargetFilePath
        );

        sftpChown.communicate(hostname, user, passwd);

        FileWriterCustom.write(puttingRootPath + "\\result.txt", sftpChown.getResult());
    }

}
