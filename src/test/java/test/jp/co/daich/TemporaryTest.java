package test.jp.co.daich;

import java.nio.file.Paths;
import jp.co.daich.driver.LonelyOnlyDriver;
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
        LonelyOnlyDriver.executeJavaScript(Paths.get("./src/main/java/jp/co/daich/javascript/src/clickListener.js"));
    }

}
