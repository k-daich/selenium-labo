package jp.co.daich.util.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author USER
 */
public class SftpLs extends SftpCommunicator {

    private final String targetPath;
    private String result;

    /**
     * @param targetPath
     */
    public SftpLs(String targetPath) {
        this.targetPath = targetPath;
    }

    /**
     * lsの結果を返す
     * @return 
     */
    public String getResult() {
        return result;
    }

    /**
     * SCPでのダウロードを実施する
     *
     * @param channel
     */
    @Override
    @SuppressWarnings({"unchecked", "unchecked"})
    public void action(ChannelSftp channel) {
        StringBuilder sBuilder = new StringBuilder();
        Vector<ChannelSftp.LsEntry> fileAndFolderList;

        try {
            fileAndFolderList = channel.ls(targetPath);
        } catch (SftpException ex) {
            throw new RuntimeException("lsコマンドに失敗しました  fiePath : " + targetPath,
                     ex);
        }

        Collections.sort(fileAndFolderList);
        fileAndFolderList.forEach((ls) -> {
            sBuilder.append(ls.toString()).append("\n");
        });
        result = sBuilder.toString();
    }

}
