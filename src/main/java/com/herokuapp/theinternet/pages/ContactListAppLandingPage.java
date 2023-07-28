package com.herokuapp.theinternet.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactListAppLandingPage extends BasePageObject{
    private final String pageUrl = "https://thinking-tester-contact-list.herokuapp.com/";
    private final By email = By.id("email");
    private final By password = By.id("password");
    private final By submitButton = By.id("submit");
    public ContactListAppLandingPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openPage() {
        log.info("Opening page " + pageUrl);
        operUrl(pageUrl);
        log.info("Page is opened!");
    }

    public void openPage(String url) {
        log.info("Opening page " + url);
        operUrl(url);
        log.info("Page is opened!");
    }
    public void enterEmail(String emailValue) {
        log.info("entering email" + emailValue);
        type(emailValue, email);
    }

    public void enterPassword(String passwordValue) {
        log.info("entering password" + passwordValue);
        type(passwordValue, password);
    }

    public ContactListAppSecurePage clickSubmitButton(){
        log.info("clicking submit");
        click(submitButton);
        log.info("opening SecureAreaPage");
        return new ContactListAppSecurePage(driver, log);
    }

}
