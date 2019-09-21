package jp.co.daich.util.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.util.Vector;
import jp.co.daich.constants.properNoun.LINUX;
import jp.co.daich.constants.properNoun.WINDOWS;
import jp.co.daich.util.logger.Logger;

/**
 *
 * @author USER
 */
public class SftpDownloader extends SftpCommunicator {

    private final String targetRootPath;
    private final String puttingRootPath;

    /**
     * @param targetRootPath
     * @param puttingRootPath
     */
    public SftpDownloader(String targetRootPath, String puttingRootPath) {
        this.targetRootPath = targetRootPath;
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
            recursiveFolderDownload(
                    channel,
                    targetRootPath + LINUX.FILE_SEPARATOR,
                    puttingRootPath + WINDOWS.FILE_SEPARATOR);
            Logger.printInfo("---- get success");
        } catch (SftpException ex) {
            // ファイルが存在しないとき
            throw new RuntimeException("ダウンロードに失敗した \n"
                    + "targetRootPath : " + targetRootPath + "\n"
                    + ex.getMessage());
        }
    }

    /**
     * This method is called recursively to download the folder content from
     * SFTP server
     *
     * @param sourcePath
     * @param destinationPath
     * @throws SftpException
     */
    @SuppressWarnings("unchecked")
    private void recursiveFolderDownload(ChannelSftp channel, String sourcePath, String destinationPath) throws SftpException {
        Vector<ChannelSftp.LsEntry> fileAndFolderList = channel.ls(sourcePath);

        // Iterate through list of folder content
        for (ChannelSftp.LsEntry item : fileAndFolderList) {

            if (!item.getAttrs().isDir()) {
                // Check if it is a file (not a directory).
                if (!(new File(destinationPath + WINDOWS.FILE_SEPARATOR + item.getFilename())).exists()
                        || (item.getAttrs().getMTime() > Long.valueOf(new File(destinationPath + WINDOWS.FILE_SEPARATOR + item.getFilename()).lastModified() / (long) 1000).intValue())) {
                    // Download only if changed later.

                    new File(destinationPath + WINDOWS.FILE_SEPARATOR + item.getFilename());
                    channel.get(
                            sourcePath + LINUX.FILE_SEPARATOR + item.getFilename(),
                            destinationPath + WINDOWS.FILE_SEPARATOR + item.getFilename());
                    // Download file from source (source filename, destination filename).
                }
            } else if (!(".".equals(item.getFilename()) || "..".equals(item.getFilename()))) {
                new File(destinationPath + WINDOWS.FILE_SEPARATOR + item.getFilename()).mkdirs();
                // Empty folder copy.
                recursiveFolderDownload(
                        channel,
                        sourcePath + LINUX.FILE_SEPARATOR + item.getFilename(),
                        destinationPath + WINDOWS.FILE_SEPARATOR + item.getFilename());
                // Enter found folder on server to read its contents and create locally.
            }
        }
    }

}
