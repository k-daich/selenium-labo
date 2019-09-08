/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.develop.util.file.image;

/**
 *
 * @author USER
 */
public class ClickHereImageProcessor {

    private static final int ADDING_IMAGE_WIDTH = 40;
    private static final int ADDING_IMAGE_HEIGHT = 40;

    public static void composit(String baseImagePath, int locationX, int locationY) {
        ImageCompositor.composit(baseImagePath,
                "./target/classes/image/clickHere.png",
                locationX + ADDING_IMAGE_WIDTH / 2,
                locationY + ADDING_IMAGE_HEIGHT / 2);
    }

}
