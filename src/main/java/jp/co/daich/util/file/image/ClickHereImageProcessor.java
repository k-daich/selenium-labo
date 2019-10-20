/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.file.image;

/**
 *
 * @author USER
 */
public class ClickHereImageProcessor {

    public static void composit(String baseImagePath, int locationX, int locationY) {
        // X,Y座標ともに指の位置を中心とするために微調整(-10)する
        ImageCompositor.composit(baseImagePath,"./target/classes/image/clickHere5.png",locationX - 64,locationY - 42);
    }

}
