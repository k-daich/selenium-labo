package jp.co.daich.manage.evi;

import java.text.DecimalFormat;

/**
 *
 * @author USER
 */
public class EviSeqManager {

    // エビデンスファイルの先頭につけるシーケンス
    private static int eviFileSeq = 0;
 
    //DecimalFormatインスタンスを生成
    private static final DecimalFormat df = new DecimalFormat("0000");

    /**
     * @return seq(format is 0000)
     */
    public static String getSeq() {
        return df.format(++eviFileSeq);
    }
}
