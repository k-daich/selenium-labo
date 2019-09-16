/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
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
            // get
            channel.put(uploadFilePath, puttingRootPath);
            Logger.printInfo("---- upload success");
        } catch (SftpException ex) {
            // ファイルが存在しないとき
            throw new RuntimeException("アップロードに失敗した \n"
                    + "uploadFilePath : " + uploadFilePath + "\n"
                    + ex.getMessage());
        }
    }
}
