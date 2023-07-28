package com.herokuapp.theinternet.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactListAppSecurePage extends BasePageObject{

    private final By bannerText = By.cssSelector("p");
    private By addContactButton = By.cssSelector("button#add-contact");
    private By logOutButton = By.cssSelector("#logout");
    private By table = By.cssSelector("div.contacts");
    public ContactListAppSecurePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public boolean isAddContactButtonVisible() {
        return find(addContactButton).isDisplayed();
    }

    public boolean isLogOutVisible() {
        return find(logOutButton).isDisplayed();
    }

    public String getBannerText() {
       return find(bannerText).getText();
    }

    public void waitForVisibilityOfTable(){
        waitForVisibilityOf(table);
    }

    public boolean checkInformation(String information) {
        List<WebElement> rows = find(table).findElements(By.tagName("tr"));
        boolean isText = false;
        for (WebElement row : rows) {
            List<WebElement> rowColumns = row.findElements(By.tagName("td"));

            for (WebElement column : rowColumns) {
                if (column.getText().contains(information)){
                    isText = true;
                }
            }
        }
        return isText;

    }



}
