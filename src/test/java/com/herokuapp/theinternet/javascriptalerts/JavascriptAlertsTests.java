package com.herokuapp.theinternet.javascriptalerts;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavascriptAlertsTests extends TestUtilities {

    @Test
    public void javaScriptAlertsTests() {

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();
        JavaScriptAlertPage javaScriptAlertPage = welcomePage.clickJSAlertPage();

        javaScriptAlertPage.openJSAlert();
        String jsAlert = javaScriptAlertPage.getAlertText();
        Assert.assertEquals(jsAlert, "I am a JS Alert", "text is not as expected");
        javaScriptAlertPage.acceptAlert();

        javaScriptAlertPage.openJSConfirm();
        String jsConfirm = javaScriptAlertPage.getAlertText();
        Assert.assertEquals(jsConfirm,("I am a JS Confirm"), "message not as expected");
        javaScriptAlertPage.acceptAlert();

        javaScriptAlertPage.openJSPrompt();
        javaScriptAlertPage.typeTextIntoAlert("");


    }
}
