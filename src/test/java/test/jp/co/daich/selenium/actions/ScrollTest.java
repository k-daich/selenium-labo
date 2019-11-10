package test.jp.co.daich.selenium.actions;

import jp.co.daich.driver.LonelyMyDriver;
import jp.co.daich.driver.develop.util.ThreadUtil;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class ScrollTest extends TestBase {

    public ScrollTest() {
    }

    @Test
    @Override
    public void doTest() {
        for (int i = 10;;) {
            LonelyMyDriver.operate().scroll(250);
            ThreadUtil.sleep(500);
            if (i-- < 0) {
                break;
            }
        }

        for (int i = 10;;) {
            LonelyMyDriver.operate().scroll(-250);
            ThreadUtil.sleep(500);
            if (i-- < 0) {
                break;
            }
        }
    }

}
