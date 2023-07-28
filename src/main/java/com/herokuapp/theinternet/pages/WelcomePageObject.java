package com.herokuapp.theinternet.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePageObject extends BasePageObject {

    private String pageUrl = "https://the-internet.herokuapp.com/";
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By jsAlerLocator = By.linkText("JavaScript Alerts");

    private By multipleWindowsLocator = By.linkText("Multiple Windows");
    public WelcomePageObject(WebDriver driver, Logger log) {
        super(driver, log);

    }

    public void openPage() {
        log.info("Opening page " + pageUrl);
        operUrl(pageUrl);
        log.info("Page is opened!");
    }

    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking Form Authentication link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }

    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking Checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    public DropdwonPage clickDropdownPage(){
        log.info("Clicking Dropdown link on Welcome Page");
        click(dropdownLinkLocator);
        return new DropdwonPage(driver, log);
    }

    public JavaScriptAlertPage clickJSAlertPage() {
        log.info("Clicking JavaScript link on Welcome Page");
        click(jsAlerLocator);
        return new JavaScriptAlertPage(driver, log);
    }

    public MultipleWindows clickMultipleWindowsPage() {
        log.info("Clicking Multiple Windows Page");
        click(multipleWindowsLocator);
        return new MultipleWindows(driver, log);
    }


}
