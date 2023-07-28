package com.herokuapp.theinternet.contactsTest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.ContactListAppLandingPage;
import com.herokuapp.theinternet.pages.ContactListAppSecurePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsPageTests extends TestUtilities {
    String expectedBannerText = "Click on any contact to view the Contact Details";
    String expectedValueInTable = "1900-01-01";


    @Test
    public void testingContacts() {
        log.info("Starting ContactsTest");
        ContactListAppLandingPage contactListAppLandingPage = new ContactListAppLandingPage(driver, log);
        contactListAppLandingPage.openPage();
        contactListAppLandingPage.enterEmail("etc@test.com");
        contactListAppLandingPage.enterPassword("J@EHNVCd322AMz3");

        ContactListAppSecurePage contactListAppSecurePage = contactListAppLandingPage.clickSubmitButton();
        contactListAppSecurePage.waitForVisibilityOfTable();
        Assert.assertTrue(contactListAppSecurePage.getBannerText().contains(expectedBannerText));
        Assert.assertTrue(contactListAppSecurePage.isAddContactButtonVisible(), " add contact button is not visible");
        Assert.assertTrue(contactListAppSecurePage.isLogOutVisible(), "logout button is not visible");
        Assert.assertTrue(contactListAppSecurePage.checkInformation(expectedValueInTable), "value is not present in table");



    }

   @Test
    public void testingInvalidUsernameOrPassword() {
        log.info("Starting InvalidUsernameOrPassword");
        ContactListAppLandingPage x = new ContactListAppLandingPage(driver, log);
        x.openPage("https://google.com/");


    }
}
