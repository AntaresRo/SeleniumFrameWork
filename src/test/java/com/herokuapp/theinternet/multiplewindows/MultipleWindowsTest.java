package com.herokuapp.theinternet.multiplewindows;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.MultipleWindows;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindowsTest  extends TestUtilities {

    @Test
    public void newWindowTest() {
        log.info("Starting newWindow Test");

        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        MultipleWindows multipleWindowsPage = welcomePageObject.clickMultipleWindowsPage();

        NewWindowPage newWindowPage = multipleWindowsPage.switchToNewWindowPage();
        String pageSource = newWindowPage.getCurrentPageSource();

        Assert.assertTrue(pageSource.contains("New Window"), "New page source does not contain new window");



    }
}
