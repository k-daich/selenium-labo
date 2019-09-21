package jp.co.daich.util.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

/**
 *
 * @author USER
 */
public class SftpChown extends SftpCommunicator {

    private final String targetFilePath;
    private final int uid;
    private String result;

    /**
     * @param uid
     * @param targetFilePath
     */
    public SftpChown(int uid, String targetFilePath) {
        this.uid = uid;
        this.targetFilePath = targetFilePath;
    }

    /**
     * chmodの結果を返す
     * @return 
     */
    public String getResult() {
        return result;
    }

    /**
     * SFTPを用いてchownを実行する
     *
     * @param channel
     */
    @Override
    @SuppressWarnings({"unchecked", "unchecked"})
    public void action(ChannelSftp channel) {
        StringBuilder sBuilder = new StringBuilder();

        try {
            sBuilder.append(channel.ls(targetFilePath).toString()).append("\n");
            sBuilder.append("                          ↑↑↑ chown Before ↑↑↑\n\n");
            channel.chown(uid, targetFilePath);
            sBuilder.append("                          ↓↓↓ chown After ↓↓↓\n");
            sBuilder.append(channel.ls(targetFilePath).toString()).append("\n");
        } catch (SftpException ex) {
            throw new RuntimeException("chownに失敗した  filePath : " + targetFilePath,
                    ex);
        }
        result = sBuilder.toString();
    }

}
