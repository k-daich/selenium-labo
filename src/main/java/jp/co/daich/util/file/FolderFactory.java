/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import jp.co.daich.util.logger.Logger;

/**
 *
 * @author USER
 */
public class FolderFactory {

    /**
     * Invalidate default constructor
     */
    private FolderFactory() {
    }

    /**
     * ディレクトリを作成する
     * @param dirPath 
     */
    public static void mkdir(String dirPath) {
        try {
            Logger.printInfo("mkdir path : " + dirPath);
            Path path1 = Paths.get(dirPath);
            Files.createDirectories(path1);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
