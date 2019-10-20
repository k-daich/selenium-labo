package test.jp.co.daich.selenium.actions;

import jp.co.daich.command.ClickHere;
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
        ClickHere.execute(By.linkText("Selenium API(逆引き)"));
//        MyLogger.printInfo("ウインドウを操作する");
//        ClickHere.execute(By.linkText("ウインドウを操作する"));
//        MyLogger.printInfo("トップページ");
//        ClickHere.execute(By.linkText("トップページ"));
//        MyLogger.printInfo("Selenium Java(ABC順)");
//        ClickHere.execute(By.linkText("Selenium Java(ABC順)"));
//        MyLogger.printInfo("トップページ");
//        ClickHere.execute(By.linkText("トップページ"));
//        MyLogger.printInfo("本サイトについて");
//        ClickHere.execute(By.linkText("本サイトについて"));
    }
}
