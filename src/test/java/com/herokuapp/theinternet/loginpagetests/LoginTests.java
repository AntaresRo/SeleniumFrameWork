package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends TestUtilities {

    @Test(priority = 1, groups = {"positiveTests", "smokeTests"})
    public void positiveLoginTest() {
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        sleep(3000);

        SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");

        Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "LogOut Button is not visible");
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = secureAreaPage.getSuccessMessageText();
        sleep(3000);
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Actual message does not match expected message\nActual message: "
                        + actualMessage + "\nExpected Message: " + expectedMessage);

    }

    @Test(priority = 2, groups = {"negativeTests", "smokeTests"})
    @Parameters({"userName", "password", "expectedMessage"})
    public void negativeLoginTest(String userName, String password, String expectedErrorMessage){
        log.info("Starting Negative Login test with: " + userName + " " + password + " " + expectedErrorMessage);
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();
        log.info("Page is opened.");

        LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();
        loginPage.logIn(userName, password);
        sleep(3000);
        WebElement errorMessage = driver.findElement(By.id("flash"));
        String actualErrorMessage = errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Error Messages are not the same");
    }




}
