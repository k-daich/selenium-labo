/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.daich.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author USER
 */
public class ProjectCommon {

    /**
     * Invalidate default Constructor
     */
    private ProjectCommon() {
    }

    public static final String EVI_DIR = "C:\\work\\3_selenium\\evi\\";
    public static final Date TEST_DATE = new Date();
    public static final String DATE_TEXT = new SimpleDateFormat("yyyyMMdd_HHmmss__").format(TEST_DATE);
}
