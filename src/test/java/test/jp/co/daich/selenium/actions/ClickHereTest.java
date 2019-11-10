package test.jp.co.daich.selenium.actions;

import jp.co.daich.command.ClickHere;
import jp.co.daich.util.logger.MyLogger;
import org.junit.Test;
import org.openqa.selenium.By;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class ClickHereTest extends TestBase{

    public ClickHereTest() {
    }

    @Test
    @Override
    public void doTest() {
        String testLinkText1 = "Selenium API(逆引き)";
        String testLinkText2 = "Seleniumインストール";
        String testLinkText3 = "トップページ";

        ClickHere.execute(By.linkText(testLinkText1));
        MyLogger.printInfo(testLinkText2);
        ClickHere.execute(By.linkText(testLinkText2));
        MyLogger.printInfo(testLinkText3);
        ClickHere.execute(By.linkText(testLinkText3));
//        MyLogger.printInfo("Selenium Java(ABC順)");
//        ClickHere.execute(myDriver, By.linkText("Selenium Java(ABC順)"));
//        MyLogger.printInfo("トップページ");
//        ClickHere.execute(myDriver, By.linkText("トップページ"));
//        MyLogger.printInfo("本サイトについて");
//        ClickHere.execute(myDriver, By.linkText("本サイトについて"));
    }

}
