/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jp.co.daich.selenium.logic;

import jp.co.daich.util.scp.ScpDownload;
import org.junit.Test;
import test.jp.co.daich.base.TestBase;

/**
 *
 * @author USER
 */
public class ScpDownloadTest extends TestBase{

    public ScpDownloadTest() {
    }

    @Test
    @Override
    public void doTest() {
                    final String hostname = "133.167.76.175";
            final String user = "jboss";
            final String passwd = "0GchCsumGutS";
            final String path = "/var/unyo/jboss/work/redmine-4.0.3.tar.gz";

        ScpDownload.download(hostname, user, passwd, path);
    }

}
