/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.util.Properties;

/**
 *
 * @author USER
 */
public abstract class SftpCommunicator {

    /**
     * SFTPでのアクション
     *
     * @param channel
     */
    protected abstract void action(ChannelSftp channel);

    /**
     * SFTP接続を行う
     *
     * @param hostname
     * @param userid
     * @param passwd
     */
    public void communicate(String hostname, String userid, String passwd) {
        ChannelSftp channel = null;
        Session session = null;
        try {
            JSch jsch = new JSch();

            // known_hosts を設定して
            // HostKey チェックを行う(HostKeyチェック無効化を行うので不要になった処理)
            // final String knownhost = "/home/jboss/.ssh/known_hosts";
            // jsch.setKnownHosts(knownhost);
            // connect session
            session = jsch.getSession(userid, hostname, 31010);
            session.setPassword(passwd);
            session.setConfig(getCustomConfig());
            session.connect();

            channel = (ChannelSftp) session.openChannel("sftp");
            // SFTP接続する
            channel.connect();
            action(channel);
        } catch (JSchException ex) {
            throw new RuntimeException("SFTP接続に失敗した : " + ex.getMessage());
        } finally {
            if (channel != null) {
                channel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }

    /**
     * セッションのコンフィグを設定する
     *
     * @param session
     */
    private static Properties getCustomConfig() {
        Properties config = new Properties();
        // 未信用ホストの場合の信用するかの確認メッセージを抑止する
        config.put("StrictHostKeyChecking", "no");
        return config;
    }

}
