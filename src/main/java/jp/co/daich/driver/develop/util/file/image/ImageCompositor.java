/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.develop.util.file.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import jp.co.daich.driver.develop.util.logger.Logger;

/**
 *
 * @author USER
 */
public class ImageCompositor {

    /**
     * Invalidate default Constructor
     */
    private ImageCompositor() {
        // none
    }

    /**
     *
     * @param baseImagePath
     * @param addingImagePath
     * @param locationX
     * @param locationY
     */
    public static void composit(String baseImagePath, String addingImagePath, int locationX, int locationY) {
        Graphics graphics = null;
        BufferedImage bufferedImage_base = getBufferedImage(baseImagePath);
        BufferedImage bufferedImage_adding = getBufferedImage(addingImagePath);
        try {
            graphics = bufferedImage_base.getGraphics();
            // 合成処理を実施する
            graphics.drawImage(bufferedImage_adding, locationX, locationY, null);
        } finally {
            graphics.dispose();
        }

        // 合成したイメージをファイルに書き出す
        try {
            ImageIO.write(bufferedImage_base, "png", new File(baseImagePath + "_compo.png"));
        } catch (IOException ex) {
            Logger.printSevere(ex.getMessage());
        }
    }

    /**
     *
     * @param path
     * @return bufferedImage
     */
    private static BufferedImage getBufferedImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException ex) {
            Logger.printSevere(ex.getMessage());
        }
        throw new RuntimeException("ファイル合成時に元となるファイルが存在せずエラー。 failePath : " + path);
    }

}
