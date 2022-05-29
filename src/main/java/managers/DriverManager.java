package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * DriverManager: Implementation Of Drivers
 *
 * @author Chethan Bidare
 */
public class DriverManager {

    private static final Supplier<WebDriver> chromeSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chrome/chromedriver.exe");
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> firefoxSupplier = () -> {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/chrome/firefox.exe");
        return new FirefoxDriver();
    };

    private static final Map<String, Supplier<WebDriver>> driverMap = new HashMap<>();

    static {
        driverMap.put("CHROME", chromeSupplier);
        driverMap.put("FIREFOX", firefoxSupplier);
    }

    public Supplier<WebDriver> getDriver(String browser) {
        return driverMap.get(browser);
    }
}
