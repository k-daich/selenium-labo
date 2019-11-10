package test.jp.co.daich;

import java.nio.file.Paths;
import jp.co.daich.command.RkRkXpathGet;
import jp.co.daich.driver.LonelyMyDriver;
import jp.co.daich.util.file.MyFileUtil;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class TemporaryTest extends TestBase {

    /**
     * Invalidate default Constructor
     */
    public TemporaryTest() {
    }

    @Test
    @Override
    public void doTest() {
        LonelyMyDriver.operate().executeJavaScript(
                Paths.get(
                        MyFileUtil.getFilePathFromProjectRoot("\\target\\classes\\docs\\rkrkXpathGet\\js\\clickListener.js")));
        RkRkXpathGet.getResult();
    }
}
