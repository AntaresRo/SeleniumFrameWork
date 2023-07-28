package com.herokuapp.theinternet.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdwonPage extends BasePageObject{
    private final By dropdown = By.id("dropdown");
    public DropdwonPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void selectOption(int i) {
        log.info("Selecting option " + i + " from dropdown");
        WebElement dropdownElement = find(dropdown);
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByValue("" + i);
    }

    public String getSelectedOption(){
        WebElement dropdwonElement = find(dropdown);
        Select dropdown = new Select(dropdwonElement);

        return dropdown.getFirstSelectedOption().getText();
    }


}
