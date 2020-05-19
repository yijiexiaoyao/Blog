package tech.acodesigner.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 */
public class PropertiesUtil {
    public static String getValue(String key) {
        Properties property = new Properties();
        InputStream is = new PropertiesUtil().getClass().getResourceAsStream("/blog.properties");
        try {
            property.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (String) property.get(key);
    }
}
