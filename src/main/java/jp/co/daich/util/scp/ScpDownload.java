/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.scp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import java.util.Vector;
import java.util.logging.Level;
import jp.co.daich.util.logger.Logger;

/**
 *
 * @author USER
 */
public class ScpDownload {

    /**
     * Invalidate default construcotr
     */
    private ScpDownload() {
    }

    /**
     * SCPでのダウロードを実施する
     *
     * @param hostname
     * @param userid
     * @param passwd
     * @param path
     */
    public static void download(String hostname, String userid, String passwd, String path) {
        try {
//        final String knownhost = "/home/****/.ssh/known_hosts";        // known_hosts ファイルのフルパス
            JSch jsch = new JSch();

//        jsch.setKnownHosts(knownhost);    // known_hosts を設定して HostKey チェックをおこなう
// connect session
            Session session = jsch.getSession(userid, hostname, 31010);
            session.setPassword(passwd);
            session.connect();

// sftp remotely
            ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
            channel.connect();

// ls
            Vector list;
            try {
                list = channel.ls(".");
                Logger.printInfo("---- ls");
                for (int i = 0; i < list.size(); i++) {
                    Logger.printInfo(list.get(i).toString());
                }
// System.out.println(list.get(0).getClass().getName());
            } catch (SftpException ex) {
                throw new RuntimeException(ex);
            }

// lstat
            try {
                SftpATTRS stat = channel.lstat("index.html");
                Logger.printInfo("---- lstat");
                Logger.printInfo(stat.toString());
                Logger.printInfo(String.valueOf(stat.getSize()));
            } catch (SftpException ex) {
                // ファイルが存在しないとき
                throw new RuntimeException(ex);
            }

// get
//            channel.get("./index.html", "./index.html.dst");
            channel.disconnect();
            session.disconnect();

        } catch (JSchException ex) {
            throw new RuntimeException(ex);
        }
    }

}
