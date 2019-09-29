package jp.co.daich.util.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author USER
 */
public class MyLogger {

    private static final Logger logger = LogManager.getLogger("debug_log");

    /**
     * print message on SEVERE LEVEL
     * @param message
     */
    public static void printInfo(String message) {
        logger.fatal("[" + Thread.currentThread().getStackTrace()[2].getFileName() + "]" + message);
    }
}
