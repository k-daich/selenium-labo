package jp.co.daich.util.file;

import java.io.File;

/**
 *
 * @author USER
 */
public class MyFileUtil {

    private static String projectRootPath;

    private static String getProjectRootPath() {
        // プロジェクトルート未取得の場合
        if (projectRootPath != null) {
            return projectRootPath;
        } else {
            return projectRootPath = new File(".").getAbsoluteFile().getParent();
        }
    }

    /**
     * プロジェクトルートからの相対パスを指定し、絶対パスが取得する
     *
     * @param relativePathFromProjectRoot
     * @return
     */
    public static String getFilePathFromProjectRoot(String relativePathFromProjectRoot) {
        //"file:\\\\" +
        return getProjectRootPath() + relativePathFromProjectRoot;
    }
}
