package com.herokuapp.theinternet.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindows extends BasePageObject{

    By clickNewWindowPage = By.linkText("Click Here");
    public MultipleWindows(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public NewWindowPage switchToNewWindowPage() {
        click(clickNewWindowPage);
        log.info("Looking for New Window Page");
        switchWindowWithTitle("New Window");
        return new NewWindowPage(driver, log);
    }

}
