package pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.BaseSetup;

import java.util.List;

/**
 * LoginPageElements : Stores All the Web Elements of Login Page
 */
public class LoginPageElements extends BaseSetup {

    @FindBy(how = How.XPATH, using = "//button[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(how = How.XPATH, using = "//input[@type='number']")
    public WebElement mobileNumberInputField;

    @FindBy(how = How.XPATH, using = "//input[@type='number']")
    public List<WebElement> otpInputFields;

    @FindBy(how = How.XPATH, using = "//button[text()='Get OTP']")
    public WebElement getOTPButton;
}
