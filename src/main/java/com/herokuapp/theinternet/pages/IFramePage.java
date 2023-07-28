package com.herokuapp.theinternet.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage extends BasePageObject{

    String pageUrl = "https://the-internet.herokuapp.com/tinymce";
    By iFrame = By.id("mce_0_ifr");
    By editor = By.id("tinymce");
    public IFramePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openPage() {
        operUrl(pageUrl);
    }

    public String getEditorText() {
        switchToIframe(iFrame);
        String text = find(editor).getText();
        log.info("Text from Editor: " + text);
        return text;
    }







}
