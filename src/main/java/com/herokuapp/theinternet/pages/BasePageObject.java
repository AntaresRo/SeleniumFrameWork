package com.herokuapp.theinternet.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePageObject {
    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    protected void operUrl(String url) {
        driver.get(url);
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator){

        return driver.findElements(locator);
    }

    protected void click(By locator){
        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        find(locator).click();
    }

    protected void type (String text, By locator){
        waitForVisibilityOf(locator, Duration.ofSeconds(5));
        find(locator).sendKeys(text);
    }

    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Duration timeOut){
        timeOut = timeOut != null ? timeOut : Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(condition);
    }

    protected void waitForVisibilityOf(By locator, Duration... timeOut) {
        int attempts = 0;
        while(attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        timeOut.length > 0 ? timeOut[0] :null);
                break;
            } catch (StaleElementReferenceException e) {

            }
            attempts++;
        }
    }

    protected Alert swtichToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    protected void switchWindowWithTitle(String expectedTitle) {
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }

    }

    protected String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

    protected void switchToIframe(By locator) {
        driver.switchTo().frame(find(locator));
    }

    protected void pressKey(By locator, Keys key) {
        find(locator).sendKeys(key);
    }

    /** Press Key using Actions class */
    public void pressKeyWithActions(Keys key) {
        log.info("Pressing " + key.name() + " using Actions class");
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }


}
