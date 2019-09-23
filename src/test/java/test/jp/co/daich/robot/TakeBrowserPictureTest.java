package test.jp.co.daich.robot;

import jp.co.daich.constants.ProjectCommon;
import jp.co.daich.robot.RobotAction;
import jp.co.daich.util.file.FolderFactory;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class TakeBrowserPictureTest extends TestBase {

    public TakeBrowserPictureTest() {
    }

    @Test
    @Override
    public void doTest() {
        final String eviDir = ProjectCommon.EVI_DIR + "takeBrowserPicture" + ProjectCommon.DATE_TEXT;
        final String fileName = "test.png";

        // エビデンスフォルダを作成する
        FolderFactory.mkdir(eviDir);

        RobotAction.takeBrowserPicture(eviDir + "\\" + fileName);
    }

}
