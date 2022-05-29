package pageObjects;

import managers.EnvironmentFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageElements.LoginPageElements;
import utils.Constants;
import utils.SeleniumUtils;
import utils.StringUtils;

import java.time.Duration;
import java.util.Properties;

/**
 * LoginPage: This Class implements Login/Signup functionalities
 *
 * @author Chethan Bidare
 */
public class LoginPage extends LoginPageElements {
    private final WebDriver driver;
    protected WebDriverWait wait;
    private final SeleniumUtils seleniumUtils;
    static Properties properties = getProperties();

    /**
     * Login Page Constructor
     *
     * @param driver - Web driver
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        seleniumUtils = new SeleniumUtils();
    }

    /**
     * Navigates to URL
     */
    public void navigateToUrl() {
        String url = EnvironmentFactory.getURL(properties.getProperty(Constants.ENVIRONMENT_STRING));
        seleniumUtils.getUrl(driver, url);
    }

    /**
     * Clicks on Sign In button
     */
    public void clickOnSignInButton() {
        seleniumUtils.clickOnElement(wait, signInButton);
    }

    /**
     * Enters Mobile Number and OTP
     */
    public void enterMobileNumberAndOTP() {
        seleniumUtils.enterText(mobileNumberInputField, StringUtils.getRandomNumbers(Constants.EIGHT));
        seleniumUtils.clickOnElement(wait, getOTPButton);
        wait.until(ExpectedConditions.invisibilityOf(getOTPButton));
        char[] chars = EnvironmentFactory.getOTP(properties.getProperty(Constants.ENVIRONMENT_STRING)).toCharArray();
        delay(Constants.TWO);
        for (int i = 0; i < otpInputFields.size(); i++) {
            otpInputFields.get(i).sendKeys(chars[i] + "");
        }
    }

    /**
     * Returns the Current URL
     *
     * @return String
     */
    public String getUrl() {
        return seleniumUtils.getCurrentUrl(driver);
    }
}
