package pageObjects;

import managers.EnvironmentFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageElements.HomePageElements;
import utils.Constants;
import utils.SeleniumUtils;
import utils.StringUtils;

import java.time.Duration;
import java.util.Set;

/**
 * HomePage: this Class contains all the flows except login page functions
 *
 * @author Chethan bidare
 */
public class HomePage extends HomePageElements {
    private final WebDriver driver;
    protected WebDriverWait wait;
    private final SeleniumUtils seleniumUtils;

    /**
     * Login Page Constructor
     *
     * @param driver - Web driver
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        seleniumUtils = new SeleniumUtils();
    }

    /**
     * Navigates to the specified Url
     *
     * @param url - URL
     */
    public void navigateToUrl(String url) {
        seleniumUtils.navigateToUrl(driver, url);
    }

    /**
     * Selects country
     *
     * @param textToBeSelected - Country name
     */
    public void selectCountry(final String textToBeSelected) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/p[text()='" + textToBeSelected + "']")));
        seleniumUtils.clickOnElement(wait, seleniumUtils.findElementByTextWithPtag(driver, textToBeSelected));
    }

    /**
     * Selects Preferred Intake and Program
     *
     * @param intake  - in take
     * @param program - Program
     */
    public void selectPreferredIntakeAndProgram(final String intake, final String program) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/p[text()='" + intake + "']")));
        seleniumUtils.clickOnElement(wait, seleniumUtils.findElementByTextWithPtag(driver, intake));
        seleniumUtils.clickOnElement(wait, seleniumUtils.findElementByTextWithPtag(driver, program));
    }

    /**
     * Selects Eduction details
     *
     * @param degreeType - Degree
     * @param percentage - Percentage/Grade
     * @param year       - Year of Graduation
     */
    public boolean selectEducationDetails(final String degreeType, final String percentage, final String year) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/p[text()='" + degreeType + "']")));
        seleniumUtils.clickOnElement(wait, seleniumUtils.findElementByTextWithPtag(driver, degreeType));
        seleniumUtils.enterText(percentageInputField, percentage + Keys.TAB);
        boolean result = validatePercentage();
        yearOfGraduationField.click();
        seleniumUtils.clickOnElementByJS(driver,seleniumUtils.findElementByTextWithDivTag(driver, year));
        return result;
    }

    /**
     * Validate Percentage/Grade field
     *
     * @return boolean
     */
    public boolean validatePercentage() {
        String percentage = seleniumUtils.getAttributeByValue(percentageInputField);
        int per = Integer.parseInt(percentage);
        boolean result;
        if (per < 10) {
            result = per >= 6;
        } else {
            result = per >= 55;
        }
        return result;
    }

    /**
     * Returns Text
     *
     * @return String
     */
    public String getThankYouText() {
        seleniumUtils.waitForElementToBeVisible(wait, thankYouMessageText);
        return seleniumUtils.getText(thankYouMessageText);
    }

    /**
     * Select Status IELTS/TOEFL exam
     *
     * @param status - Status
     */
    public void selectStatusIeltsToeflExam(String status) {
        seleniumUtils.waitForElementToBeVisible(wait, ieltsStatusField);
        seleniumUtils.clickOnElement(wait, ieltsStatusField);
        seleniumUtils.clickOnElement(wait, findElementByTextWithDivTag(driver, status));
    }

    /**
     * Selects university Admit
     *
     * @param status - Status
     */
    public void selectUniversityAdmit(String status) {
        seleniumUtils.clickOnElement(wait, admitStatusField);
        seleniumUtils.clickOnElement(wait, findElementByTextWithDivTag(driver, status));
    }

    /**
     * Enters Random Name and email address
     */
    public void enterNameAndEmailAddress() {
        seleniumUtils.waitForElementToBeClickable(wait, nameInputField);
        String name = StringUtils.generateRandomString(Constants.SEVEN);
        seleniumUtils.enterText(nameInputField, name);
        seleniumUtils.enterText(emailInputField, name + Constants.AT_GMAIL_COM_STRING);
    }

    /**
     * Clicks on Complete button
     */
    public void clickOnCompleteButton() {
        seleniumUtils.clickOnElement(wait, completeButton);
    }

    /**
     * Click on Claim Access button
     */
    public void clickOnClaimAccessButton() {
        seleniumUtils.clickOnElementByJS(driver, claimAccessButton);
    }

    /**
     * Clicks on Dashboard
     */
    public void clickOnGotoDashboardButton() {
        delay(7);
        seleniumUtils.clickOnElementByJS(driver, goToDashboardButton);
    }


    /**
     * Returns the Current URL
     *
     * @return String
     */
    public String getUrl() {
        return seleniumUtils.getCurrentUrl(driver);
    }

    /**
     * Validate Slot 3 Url
     *
     * @param expectedUrl - Expected Url
     * @return boolean
     */
    public boolean validateUrl(String expectedUrl) {
        seleniumUtils.waitForUrlToBe(wait, expectedUrl);
        return getUrl().equalsIgnoreCase(expectedUrl);
    }

    /**
     * Clicks on Home link
     */
    public void clickOnHomeLink() {
        seleniumUtils.clickOnElement(wait, homeLink);
    }

    /**
     * Clicks on Goto Profile
     */
    public void clickOnGotoProfile() {
        seleniumUtils.clickOnElement(wait, gotoProfileButton);
    }

    /**
     * Confirm Slot
     */
    public void confirmSlot(){
        seleniumUtils.clickOnElement(wait, slotField);
        seleniumUtils.clickOnElement(wait, confirmSlotButton);
    }

    /**
     * Clicks on Skip for now blink
     */
    public void clickOnSkipForNow(){
        seleniumUtils.clickOnElement(wait, skipForNowlink);
        seleniumUtils.clickOnElement(wait,IWantToSkipButton);
    }

    /**
     * Clicks on Get LS Plus Now Button
     */
    public void clickOnGetLsPlusNowButton(){
        seleniumUtils.clickOnElement(wait, getLSPlusNowButton);
    }

    /**
     * Clicks on Pay Now Button
     */
    public void clickOnPayNowButton(){
        seleniumUtils.clickOnElement(wait, payNowButton);
    }

    /**
     * Clicks on Net Banking and Selects SBI
     */
    public void clickOnNetBankingAndSelectSBI(){
        scrollToAnElementByJS(driver, netBankingButton);
        seleniumUtils.clickOnElement(wait, sbiId);
        seleniumUtils.clickOnElement(wait, pay199Button);
    }

    /**
     * Click on success button
     */
    public void clickOnSuccessButton(){
        String parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String w : windows){
            if (!w.equalsIgnoreCase(parentWindow)){
                driver.switchTo().window(w);
                seleniumUtils.clickOnElement(wait, successButton);
                driver.switchTo().window(parentWindow);
                break;
            }
        }
    }
}
