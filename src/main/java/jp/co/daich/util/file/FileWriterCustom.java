/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author USER
 */
public class FileWriterCustom {
    private FileWriterCustom() {
    }
    /**
     * 指定の出力先に指定の内容を出力する
     * @param fileName
     * @param content 
     */
    public static void write(String fileName, String content) {
        try (FileWriter fWriter = new FileWriter(fileName)) {
            fWriter.write(content);
            fWriter.close();
        }
        catch (IOException ex) {
            throw new RuntimeException("failed to create version.txt. dest : " + fileName);
        }
    }
}
