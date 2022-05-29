package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;

/**
 * PageObjectManager: This Class provides the instance of All the Page Objects
 *
 * @author Chethan Bidare
 */
public class PageObjectManager {
    public WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ExcelManager excelManager;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public ExcelManager getExcelManager() {
        return (excelManager == null) ? excelManager = new ExcelManager() : excelManager;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
}
