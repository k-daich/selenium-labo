/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.file.image;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import jp.co.daich.util.logger.MyLogger;

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

    private static int fileSeq = 0;

    /**
     * baseImageにaddingImageを合成(上書き)する。
     *
     * @param baseImagePath
     * @param addingImagePath
     * @param locationX
     * @param locationY
     */
    public static void composit(String baseImagePath, String addingImagePath, int locationX, int locationY) {
        Graphics2D graphics = null;
        BufferedImage bufferedImage_base = getBufferedImage(baseImagePath);
        BufferedImage bufferedImage_adding = getBufferedImage(addingImagePath);
        try {
            graphics = bufferedImage_base.createGraphics();
            // 合成画像の透明度を指定する
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8F));
            // 合成処理を実施する
            graphics.drawImage(
                    bufferedImage_adding,
                    locationX,
                    locationY,
                    null);

            MyLogger.printInfo("actual draw X at : " + locationX);
            MyLogger.printInfo("actual draw Y at : " + locationY);
        } finally {
            if (graphics != null) {
                graphics.dispose();
            }
        }

        // 合成したイメージをファイルに書き出す
        writeImage(bufferedImage_base, "png", baseImagePath + fileSeq++ + "_compo.png");
    }

    /**
     * 複数の画像リストを縦一列に並べる
     *
     * @param captureList
     * @param compositedStorePath
     */
    public static void composit(List<String> captureList, String compositedStorePath) {
        // スクショ一枚目をファイルパスを取得
        String capture1 = captureList.get(0);
        // スクショ一枚目のイメージデータ取得
        BufferedImage bufImage1 = getBufferedImage(capture1);
        int width = bufImage1.getWidth();
        int height = bufImage1.getHeight();

        // 合成後の画像の縦横サイズを指定して、新しい画像オブジェクトを作る
        // 縦に並べるわけだから、高さは 一枚目の高さをベースに、スクショ枚数分とっておく
        // この時点では画像は真っ黒な状態
        BufferedImage compoImg_dest = new BufferedImage(
                bufImage1.getWidth(), // 合成画像の幅指定
                bufImage1.getHeight() * captureList.size(), // 合成画像の高さ指定(一枚の高さ × 合成枚数)
                BufferedImage.TYPE_INT_ARGB); // TODO: 合成画像のタイプ指定（調べてないから後で調べる。。。）
        Graphics g = compoImg_dest.getGraphics();

        // 画像合成済みの高さ
        int _compositedHeight = 0;
        for (String capture : captureList) {
            // 画像を読み込んでオブジェクトにする
            BufferedImage parts = getBufferedImage(capture);
            g.drawImage(
                    parts, // 合成パーツ画像指定
                    0, // 合成開始X座標は左端（ゼロ指定）
                    _compositedHeight, // 合成開始Y座標は合成済み高さ
                    null); // Observer指定（オプション的なやつみたいだが、よく知らん）
            _compositedHeight = _compositedHeight + parts.getHeight(); // 合成済みの高さを更新
        }

        // 合成後の画像をファイルに出力
        writeImage(compoImg_dest, "png", compositedStorePath);
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
            MyLogger.printInfo(ex.getMessage());
        }
        throw new RuntimeException("ファイル合成時に元となるファイルが存在せずエラー。 failePath : " + path);
    }

    /**
     * 画像ファイルを書き込む
     *
     * @param image
     * @param imageType
     * @param writeFilePath
     */
    private static void writeImage(BufferedImage image, String imageType, String writeFilePath) {
        try {
            ImageIO.write(image, imageType, new File(writeFilePath));
        } catch (IOException ex) {
            MyLogger.printInfo(ex.getMessage());
        }
    }

}
