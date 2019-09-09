/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.file.image;

import jp.co.daich.util.logger.Logger;

/**
 *
 * @author USER
 */
public class ClickHereImageProcessor {

    private static final int ADDING_IMAGE_WIDTH = 40;
    private static final int ADDING_IMAGE_HEIGHT = 40;

    public static void composit(String baseImagePath, int locationX, int locationY) {
        Logger.printInfo("adding width : " + ADDING_IMAGE_WIDTH / 2);
        Logger.printInfo("adding height : " + ADDING_IMAGE_HEIGHT / 2);
        ImageCompositor.composit(baseImagePath,
                "./target/classes/image/clickHere.png",
                locationX + ADDING_IMAGE_WIDTH / 2,
                locationY + ADDING_IMAGE_HEIGHT / 2);
    }

}
