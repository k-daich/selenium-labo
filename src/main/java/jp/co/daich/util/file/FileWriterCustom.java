/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import jp.co.daich.util.logger.MyLogger;

/**
 *
 * @author USER
 */
public class FileWriterCustom {

    private FileWriterCustom() {
    }

    /**
     * 指定の出力先に指定の内容を出力する
     *
     * @param fileName
     * @param content
     */
    public static void write(String fileName, String content) {
        try (PrintWriter writer = 
                new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8")))) {
            writer.write(content);
            writer.close();
        } catch (IOException ex) {
            throw new RuntimeException("failed to create version.txt. dest : " + fileName);
        }
    }

    /**
     * create empty file
     *
     * @param filePath
     */
    public static void createNewEmptyFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                MyLogger.printInfo("--- create file success : " + filePath);
            } else {
                MyLogger.printInfo("--- create file failed : " + filePath);
            }
        } catch (IOException ex) {
            throw new RuntimeException("空ファイルの作成に失敗しました : " + filePath,
                    ex);
        }
    }

    /**
     * ファイルをコピーします
     * @param src
     * @param dest 
     */
    public static void copy(String src, String dest) {
        try {
            Path sourcePath = Paths.get(src);
            Path targetPath = Paths.get(dest);
            Files.copy(sourcePath, targetPath);

            MyLogger.printInfo("コピーが成功しました");

        } catch (IOException ex) {
            throw new RuntimeException("コピーに失敗しました \n source " + src
                    + "\n dest " + dest,
                     ex);
        }
    }
}
