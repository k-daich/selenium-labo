/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.command;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import jp.co.daich.constants.ProjectCommon;
import jp.co.daich.driver.LonelyOnlyDriver;
import jp.co.daich.robot.RobotAction;
import jp.co.daich.util.file.FolderFactory;
import jp.co.daich.util.logger.MyLogger;

/**
 *
 * @author USER
 */
public class CtrlFSearch {

    /**
     * invaliate default Constructor
     */
    private CtrlFSearch() {
        // none
    }

    private static final String IMG_STORE_PATH = ProjectCommon.EVI_DIR + "ctrlFSearch_" + ProjectCommon.DATE_TEXT;

    public static void execute(String keyword) {
        MyLogger.printInfo("☆☆☆☆☆CtrlFSearch Start☆☆☆☆☆");
        // 格納先ディレクトリを作成する
        FolderFactory.mkdir(IMG_STORE_PATH);

        try {
            long waitTime = 1000;

            // 検索フォームの表示
            pushCtrlF();

            // 検索フォームが表示されるまで時間がかかるので少し待機する
            Thread.sleep(waitTime);

            // クリップボードを利用して検索フォームに検索文字列を入力する
            inputTextByClipBord(keyword);

            // スクリーンショットを取得し保存する
            LonelyOnlyDriver.getScreenShot(IMG_STORE_PATH);

            // 検索フォームの取り消し
            pushEscape();

        } catch (InterruptedException e) {
            MyLogger.printInfo(e.getMessage());
        }

    }

    /**
     * push Ctrl + F by Robot
     */
    private static void pushCtrlF() {
        RobotAction.keyPress(KeyEvent.VK_CONTROL);
        RobotAction.keyPress(KeyEvent.VK_F);
        RobotAction.keyRelease(KeyEvent.VK_F);
        RobotAction.keyRelease(KeyEvent.VK_CONTROL);
    }

    /**
     * input text by clipboard
     */
    private static void inputTextByClipBord(String keyword) {
        StringSelection stringSelection = new StringSelection(keyword);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        clipboard.setContents(stringSelection, stringSelection);

        RobotAction.keyPress(KeyEvent.VK_CONTROL);
        RobotAction.keyPress(KeyEvent.VK_V);
        RobotAction.keyRelease(KeyEvent.VK_V);
        RobotAction.keyRelease(KeyEvent.VK_CONTROL);
    }

    /**
     * push escape key
     */
    private static void pushEscape() {
        RobotAction.keyPress(KeyEvent.VK_ESCAPE);
        RobotAction.keyRelease(KeyEvent.VK_ESCAPE);
    }

}
