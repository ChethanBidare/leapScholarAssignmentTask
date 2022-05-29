package pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.BaseSetup;

import java.util.List;

/**
 * HomePageElements: Web Elements of Home Page
 */
public class HomePageElements extends BaseSetup {

    @FindBy(how = How.XPATH, using = "//span/p[text()='Country']")
    public WebElement countryDropdown;

    @FindBy(how = How.ID, using = "field-grades")
    public WebElement percentageInputField;

    @FindBy(how = How.ID, using = "field-highestEducationPassoutYear")
    public WebElement yearOfGraduationField;

    @FindBy(how = How.ID, using = "field-admitStatus")
    public WebElement admitStatusField;

    @FindBy(how = How.ID, using = "field-ieltsStatus")
    public WebElement ieltsStatusField;

    @FindBy(how = How.ID, using = "field-name")
    public WebElement nameInputField;

    @FindBy(how = How.ID, using = "field-email")
    public WebElement emailInputField;

    @FindBy(how = How.XPATH, using = "//button/p[text()='COMPLETE']")
    public WebElement completeButton;

    @FindBy(how = How.XPATH, using = "//button/p[text()='Claim access']")
    public WebElement claimAccessButton;

    @FindBy(how = How.XPATH, using = "//button/p[text()='Go to Dashboard ']")
    public WebElement goToDashboardButton;

    @FindBy(how = How.XPATH, using = "//div/p[text()='Home']")
    public WebElement homeLink;

    @FindBy(how = How.XPATH, using = "//p[text()='Thank you for signing up with Leap Scholar!']")
    public WebElement thankYouMessageText;

    @FindBy(how = How.XPATH, using = "//button/span[text()='Go to Profile']")
    public WebElement gotoProfileButton;

    @FindBy(how = How.XPATH, using = "//div[text()='All Countries']")
    public WebElement slotField;

    @FindBy(how = How.XPATH, using = "//button[text()='Confirm Slot']")
    public WebElement confirmSlotButton;

    @FindBy(how = How.XPATH, using = "//div/p[text()='Skip for now ']")
    public WebElement skipForNowlink;

    @FindBy(how = How.XPATH, using = "//button[text()='Yes, I want to skip']")
    public WebElement IWantToSkipButton;


    @FindBy(how = How.XPATH, using = "//button/div/p[text()='Get LS Plus now']")
    public WebElement getLSPlusNowButton;

    @FindBy(how = How.XPATH, using = "//button//span[text()='Pay Now']")
    public WebElement payNowButton;

    @FindBy(how = How.XPATH, using = "//button//span[text()='Pay Now']")
    public WebElement netBankingButton;

    @FindBy(how = How.ID, using = "bank-item-SBIN")
    public WebElement sbiId;

    @FindBy(how = How.XPATH, using = "//div/span[contains(text(),'Pay')]/following::span")
    public WebElement pay199Button;

    @FindBy(how = How.XPATH, using = "//button[text()='Success']")
    public WebElement successButton;
}
