package cucumber;

import managers.DriverManager;
import managers.EnvironmentFactory;
import managers.ExcelManager;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import utils.BaseSetup;

/**
 * Test Context: This Class is used to share the information b/w Different Steps to a Test
 *
 * @author Chethan Bidare
 */
public class TestContext extends BaseSetup {
    private final DriverManager driverManager;
    private final PageObjectManager pageObjectManager;
    private final ExcelManager excelManager;

    /**
     * Constructor
     */
    public TestContext(){
        driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver(getProperties().getProperty("browser")).get();
        pageObjectManager = new PageObjectManager(driver);
        excelManager = new ExcelManager();
    }

    /**
     * returns Driver Manager instance
     * @return Class
     */
    public DriverManager getDriverManager(){
        return driverManager;
    }

    /**
     * returns PageObjectManager instance
     *
     * @return Class
     */
    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }

    public ExcelManager getExcelManager(){
        return excelManager;
    }
}
