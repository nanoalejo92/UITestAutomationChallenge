package com.ebay.base;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriver() {
        System.setProperty(GlobalVariables.CHROME_DRIVER_KEY, GlobalVariables.CHROME_DRIVER_NAME);
        driver = new ChromeDriver();
        return driver;
    }

    /*
     * Implicitly wait
     */
    public void implicitlyWait(int seconds) {
        try {
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    /*
     * Implicitly wait
     */
    public void implicitlyWait() {
        try {
            driver.manage().timeouts().implicitlyWait(GlobalVariables.GENERAL_IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    /*
     * Wait for element present (sync)
     */

    /*public void waitForElementPresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.GENERAL_TIMEOUT);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }*/
    
    /*
     * Wait for element present (sync) (overloading)
     */

    /*public void waitForElementPresent(By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }*/

    /*
     * Launch browser
     */
    public void launchBrowser(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        implicitlyWait();
    }


    /*
     * Type
     */
    public void type(By locator, String inputText) {
        try {
            driver.findElement(locator).sendKeys(inputText);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /*
     * Click
     */

    public void click(By locator) {
        try {
            driver.findElement(locator).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /*
     * isDisplayed
     */
    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
     * Get text method
     */
    public String getText(By locator) {
        try {
            return driver.findElement(locator).getText();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     *  Assertion (String)
     */
    public void assertEquals(String actualValue, String expectedValue) {
        try {
            Assert.assertEquals(actualValue, expectedValue);
        } catch(AssertionError e) {
            Assert.fail(e.getMessage() + "Actual value "+actualValue+ " does not match with Expected Value "+expectedValue);
        }
    }

    /*
     *  Assertion (Int)
     */
    public void assertEquals(int actualValue, int expectedValue) {
        try {
            Assert.assertEquals(actualValue, expectedValue);
        } catch(AssertionError e) {
            Assert.fail(e.getMessage() + "Actual value "+actualValue+ " does not match with Expected Value "+expectedValue);
        }
    }

    /*
     * Close Browser
     */
    public void closeBrowser() {
        driver.close();
    }
}
