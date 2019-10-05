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
        ImageCompositor.composit(baseImagePath,"./target/classes/image/clickHere.png",locationX,locationY);
    }

}
