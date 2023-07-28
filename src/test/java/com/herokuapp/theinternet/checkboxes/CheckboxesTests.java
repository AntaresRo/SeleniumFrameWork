package com.herokuapp.theinternet.checkboxes;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxesTests extends TestUtilities {
    @Test
    public void selectingTwoCheckboxes() {
        log.info("Starting selectingTwoCheckboxesTest");
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();
        checkboxesPage.selectAllCheckboxes();

        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");
    }
}
