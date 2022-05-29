package managers;

import utils.BaseSetup;

import java.util.HashMap;
import java.util.Properties;
import java.util.function.Supplier;

/**
 * EnvironmentFactory: Implements the environment related variables specified in the Config file
 * Environments Handled: QA, STAGING
 */
public class EnvironmentFactory extends BaseSetup {
    private static final Properties properties = getProperties();
    private static final String QA_URL = "qaUrl";
    private static final String STAGING_URL = "stagingUrl";
    private static final String STAGING_OTP = "stagingOtp";
    private static final String QA_OTP = "qaOtp";

    private static final Supplier<String> qaUrlSupplier = () -> properties.getProperty(QA_URL);

    private static final Supplier<String> stagingUrlSupplier = () -> properties.getProperty(STAGING_URL);

    private static final Supplier<String> stagingOTP = () -> properties.getProperty(STAGING_OTP);

    private static final Supplier<String> qaOTP = () -> properties.getProperty(QA_OTP);

    private static final HashMap<String, Supplier<String>> URL_MAP = new HashMap<>();
    private static final HashMap<String, Supplier<String>> USER_OTP = new HashMap<>();

    static {
        URL_MAP.put("qa", qaUrlSupplier);
        URL_MAP.put("staging", stagingUrlSupplier);

        USER_OTP.put("qa", qaOTP);
        USER_OTP.put("staging", stagingOTP);
    }

    public static String getURL(String environment) {
        return URL_MAP.get(environment).get();
    }

    public static String getOTP(String environment) {
        return USER_OTP.get(environment).get();
    }
}
