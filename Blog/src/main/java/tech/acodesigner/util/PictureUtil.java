package tech.acodesigner.util;

import java.io.File;

/**
 *
 */
public class PictureUtil {

    public static String[] getPictures(String basePath, String picture) {
        File pictureDirector = new File(basePath + File.separator + picture);
        String[] pictures = pictureDirector.list();
        return pictures;
    }
}
