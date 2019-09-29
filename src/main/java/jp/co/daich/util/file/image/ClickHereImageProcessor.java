/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.file.image;

import jp.co.daich.util.Calculator;
import jp.co.daich.util.logger.MyLogger;

/**
 *
 * @author USER
 */
public class ClickHereImageProcessor {

    private static final int ADDING_IMAGE_WIDTH = 40;
    private static final int ADDING_IMAGE_HEIGHT = 40;

    public static void composit(String baseImagePath, int locationX, int locationY) {
        MyLogger.printInfo("adding width : " + ADDING_IMAGE_WIDTH / 2);
        MyLogger.printInfo("adding height : " + ADDING_IMAGE_HEIGHT / 2);
        ImageCompositor.composit(baseImagePath,
                "./target/classes/image/clickHere.png",
                // tried 1 : 1.2706
                // tried 2 : 1.2519
                Calculator.multiply(locationX, 1.2706) + ADDING_IMAGE_WIDTH / 2,
                Calculator.multiply(locationY, 1.2706) + ADDING_IMAGE_HEIGHT / 2);
        ImageCompositor.composit(baseImagePath,
                "./target/classes/image/clickHere.png",
                // tried 1 : 1.2706
                // tried 2 : 1.2519
                Calculator.multiply(locationX, 1.2519) + ADDING_IMAGE_WIDTH / 2,
                Calculator.multiply(locationY, 1.2519) + ADDING_IMAGE_HEIGHT / 2);
    }

}
