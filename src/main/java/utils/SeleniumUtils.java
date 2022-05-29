package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * SeleniumUtils: This Class implements Selenium Methods and Waits
 *
 * @author Chethan Bidare
 */
public class SeleniumUtils {

    /**
     * Navigates to URL
     * @param driver - Webdriver
     * @param url- url
     */
    public void getUrl(WebDriver driver, String url){
        driver.manage().window().maximize();
        driver.get(url);
    }

    /**
     * Navigates to URL
     * @param driver - Webdriver
     * @param url- url
     */
    public void navigateToUrl(WebDriver driver, String url){
        driver.navigate().to(url);
    }

    /**
     * Returns Current URL
     * @param driver - WebDriver
     * @return String
     */
    public String getCurrentUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    /**
     * Finds Element By Text which has p tag
     * @param driver - driver
     * @param text - text
     * @return Web element
     */
    public WebElement findElementByTextWithPtag(WebDriver driver, String text){
        return driver.findElement(By.xpath("//div/p[text()='"+text+"']"));
    }

    /**
     * Finds Element By Text which has Div tag
     * @param driver - driver
     * @param text - text
     * @return Web element
     */
    public WebElement findElementByTextWithDivTag(WebDriver driver, String text){
        return driver.findElement(By.xpath("//div[text()='"+text+"']"));
    }

    /**
     * Clicks on element
     * @param wait - Webdriver wait
     * @param webElement - Web Element
     */
    public void clickOnElement(WebDriverWait wait, WebElement webElement){
        waitForElementToBeClickable(wait, webElement);
        webElement.click();
    }


    /**
     * Clicks on element by Javascript
     * @param webElement - Web Element
     */
    public void clickOnElementByJS(WebDriver driver, WebElement webElement){
        delay(2);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", webElement);
    }

    /**
     * waits for element tp be clickable
     * @param wait - WebDriver Wait
     * @param webElement - Web element
     */
    public void waitForElementToBeClickable(WebDriverWait wait, WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * waits for element tp be visible
     * @param wait - WebDriver Wait
     * @param webElement - Web element
     */
    public void waitForElementToBeVisible(WebDriverWait wait, WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Waits for an Url
     * @param wait - Webdriver wait
     * @param url - url
     */
    public void waitForUrlToBe(WebDriverWait wait, String url){
        wait.until(ExpectedConditions.urlToBe(url));
    }

    /**
     * Enters Text
     * @param webElement - Web Element
     * @param text - Text
     */
    public void enterText(WebElement webElement, String text){
        webElement.sendKeys(text);
    }

    /**
     * Get Attribute by value
     * @param webElement - Web Element
     * @return String
     */
    public String getAttributeByValue(WebElement webElement){
        return webElement.getAttribute(Constants.VALUE_STRING);
    }
    /**
     * driver waits for specified time
     * @param secs - Seconds
     */
    public void delay(int secs){
        try {
            Thread.sleep((long)secs * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get Text
     * @param webElement - Web Element
     * @return String
     */
    public String getText(WebElement webElement){
        return webElement.getText();
    }

    /**
     *  Scrolls to a particular Element
     * @param driver - WebDriver
     * @param webElement - Web Element
     */
    public void scrollToAnElementByJS(WebDriver driver, WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true;)",webElement);
    }
}
