package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.base.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestUtilities {
    @Test(priority = 1, groups = {"negativeTests", "smokeTests"})
    @Parameters({"userName", "password", "expectedMessage"})
    public void negativeLoginTest(String userName, String password, String expectedErrorMessage){

        String url = "https://the-internet.herokuapp.com/login";

        log.info("Starting Negative Login test with: " + userName + " " + password + " " + expectedErrorMessage);
        driver.get(url);

        log.info("Page is opened.");
        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.sendKeys(userName);

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys(password);

        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("flash"));

        String actualErrorMessage = errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Error Messages are not the same");

        driver.quit();
    }






}
