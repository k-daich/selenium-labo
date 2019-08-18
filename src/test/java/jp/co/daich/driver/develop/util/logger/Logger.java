/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.driver.develop.util.logger;

import java.util.logging.Level;

/**
 *
 * @author USER
 */
public class Logger {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
    
    /**
     * print message on SEVERE LEVEL
     * @param message
     */
    public static void printSevere(String message) {
            logger.log(Level.SEVERE, message);
    }
}
