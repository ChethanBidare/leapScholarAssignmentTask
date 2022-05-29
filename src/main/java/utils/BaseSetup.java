package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * BaseSetup: This Class handles all the Base methods
 *
 * @author Chethan Bidare
 */
public class BaseSetup extends SeleniumUtils{

    /**
     * Returns properties
     *
     * @return Properties
     */
    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(Constants.APP_USER_DIR_LOCATION + "Config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
