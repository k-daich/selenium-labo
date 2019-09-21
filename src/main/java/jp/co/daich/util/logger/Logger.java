/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.util.logger;

/**
 *
 * @author USER
 */
public class Logger {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("debug_log");

    /**
     * print message on SEVERE LEVEL
     *
     * @param message
     */
    public static void printInfo(String message) {
        logger.severe("[" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + message);
    }
}
