/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import jp.co.daich.util.logger.MyLogger;

/**
 *
 * @author USER
 */
public class SftpUtil {

    /**
     * Invalidate default constructor
     */
    private SftpUtil() {
    }

    /**
     * ファイルが存在するか
     *
     * @param channel
     * @param filePath
     * @return ファイルが存在するか
     */
    public static boolean isExist(ChannelSftp channel, String filePath) {
        try {
            MyLogger.printInfo("file judge exist filePath : " + filePath);
            channel.ls(filePath);
            MyLogger.printInfo("file judge exist : TRUE");
            // lsメソッドが正常実行した場合はファイルが存在したことになるのでtrueを返す
            return true;
        } // lsでファイルが存在しない場合はSftpExceptionが発生する // lsでファイルが存在しない場合はSftpExceptionが発生する
        catch (SftpException ex) {
            // lsの結果、ファイルが存在しない場合の例外が発生した場合
            if ("No such file".equals(ex.getMessage())) {
                MyLogger.printInfo("file judge exist : FALSE");
                return false;
            } // 想定外のエラーが発生した
            else {
                throw new RuntimeException("[SftpUtil] ファイル存在判定処理で想定外エラーが発生した\n",
                        ex);
            }
        }
    }
}
