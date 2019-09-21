/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import jp.co.daich.util.file.FileWriterCustom;
import jp.co.daich.util.logger.Logger;

/**
 *
 * @author USER
 */
public class SftpUploader extends SftpCommunicator {

    private final String uploadFilePath;
    private final String puttingRootPath;

    /**
     * Constructor
     *
     * @param uploadFilePath
     * @param puttingRootPath
     */
    public SftpUploader(String uploadFilePath, String puttingRootPath) {
        this.uploadFilePath = uploadFilePath;
        this.puttingRootPath = puttingRootPath;
    }

    /**
     * SCPでのダウロードを実施する
     *
     * @param channel
     */
    @Override
    @SuppressWarnings("unchecked")
    public void action(ChannelSftp channel) {
        try {
            // アップロード先にファイルが既にある場合は上書きしてしまう前にダウンロードする
            if (SftpUtil.isExist(channel, puttingRootPath)) {
                // download
                channel.get(puttingRootPath, uploadFilePath + "__before.txt");
                Logger.printInfo("---- pre download : " + uploadFilePath + "__before.txt");
            } else {
                // 存在しない旨のコメントファイルを作成する
                FileWriterCustom.createNewEmptyFile(uploadFilePath + "__before_notExist");
                Logger.printInfo("---- not exist , create file : " + uploadFilePath + "__before_notExist.txt");
            }
            // upload
            channel.put(uploadFilePath, puttingRootPath);
            channel.setMtime(puttingRootPath, (int) TimeUnit.MILLISECONDS.toSeconds((new Date()).getTime()));
            Logger.printInfo("---- upload success\n"
            + channel.ls(puttingRootPath).toString());

            FileWriterCustom.copy(uploadFilePath, uploadFilePath + "_after.txt");
        } catch (SftpException ex) {
            // ファイルが存在しないとき
            throw new RuntimeException("アップロードに失敗した \n"
                    + "uploadFilePath : " + uploadFilePath + "\n"
                    + ex.getMessage(),
                    ex);
        }
    }

}
