package jp.co.daich.util.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import jp.co.daich.util.logger.MyLogger;

/**
 * @author USER
 */
public class MyInputStreamReader {

    public static String readFile(Path filePath) {
        StringBuilder sBuilder = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            // 自動close brがnullでもOK
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                sBuilder.append(line).append("\n");
            }
        } catch (IOException ex) {
            throw new RuntimeException("Failed read file. file path : " + filePath, ex);
        }
        MyLogger.printInfo(sBuilder.toString());
        return sBuilder.toString();
    }
}
