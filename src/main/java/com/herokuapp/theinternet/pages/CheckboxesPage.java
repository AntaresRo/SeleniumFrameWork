package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.TestUtilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage extends BasePageObject {

    private final By checkbox = By.xpath("//input[@type='checkbox']");

    public CheckboxesPage(WebDriver driver, Logger log) {

        super(driver, log);
    }

    public  void selectAllCheckboxes() {
        log.info("Checking all unchecked checkboxes");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public  boolean areAllCheckboxesChecked() {
        log.info("Verifying that all checkboxes are checked");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }

}
