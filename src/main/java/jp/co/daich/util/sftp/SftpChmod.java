package jp.co.daich.util.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

/**
 *
 * @author USER
 */
public class SftpChmod extends SftpCommunicator {

    private final String targetFilePath;
    private final int permissions;
    private String result;

    /**
     * @param permissions
     * @param targetFilePath
     */
    public SftpChmod(int permissions, String targetFilePath) {
        this.permissions = permissions;
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
     * SFTPを用いてchmodを実行する
     *
     * @param channel
     */
    @Override
    @SuppressWarnings({"unchecked", "unchecked"})
    public void action(ChannelSftp channel) {
        StringBuilder sBuilder = new StringBuilder();

        try {
            sBuilder.append(channel.ls(targetFilePath).toString()).append("\n");
            sBuilder.append("                          ↑↑↑ chmod Before ↑↑↑\n\n");
            channel.chmod(permissions, targetFilePath);
            sBuilder.append("                          ↓↓↓ chmod After ↓↓↓\n");
            sBuilder.append(channel.ls(targetFilePath).toString()).append("\n");
        } catch (SftpException ex) {
            throw new RuntimeException("chmodに失敗した  filePath : " + targetFilePath,
                    ex);
        }
        result = sBuilder.toString();
    }

}
