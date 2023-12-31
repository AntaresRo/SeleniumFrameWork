package com.herokuapp.theinternet.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{


    private By usernameLocator = By.id("username");
    private By passwordLocator = By.name("password");
    private By logInButtonLocator = By.tagName("button");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);

    }

    public SecureAreaPage logIn(String username, String password) {
        log.info("Executing LogIn with userName [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(logInButtonLocator);
        return new SecureAreaPage(driver, log);
    }
}
