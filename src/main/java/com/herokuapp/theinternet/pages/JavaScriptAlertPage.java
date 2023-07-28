package com.herokuapp.theinternet.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage extends BasePageObject{

    private final By clickForJSAlertButton = By.xpath("//button[text() = 'Click for JS Alert']");
    private final By clickForPromptButton = By.xpath("//button[text() = 'Click for JS Confirm']");
    private final By clickForJSPromptButton = By.xpath("//button[text() = 'Click for JS Prompt']");
    private final By resultTextLocator = By.id("result");
    public JavaScriptAlertPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openJSAlert(){
        log.info("Clicking on 'Click for JS Alert' button to open alert");
        click(clickForJSAlertButton);
    }

    public void openJSConfirm(){
        log.info("Clicking on 'Click for JS Confirm' button to open alert");
        click(clickForPromptButton);
    }

    public void openJSPrompt(){
        log.info("Clicking on 'Click for JS Prompt' button to open alert");
        click(clickForJSPromptButton);
    }

    public String getAlertText(){
        Alert alert = swtichToAlert();
        String alertText = alert.getText();
        log.info("Alert says: " + alertText);
        return alertText;
    }

    public void acceptAlert() {
        log.info("Switching to alert and pressing OK");
        Alert alert = swtichToAlert();
        alert.accept();
    }

    public void dismissAlert() {
        log.info("Switching to alert and pressing Cancel");
        Alert alert = swtichToAlert();
        alert.dismiss();
    }

    public void typeTextIntoAlert(String text){
        log.info("Typing text into alert and pressing OK");
        Alert alert = swtichToAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResultText(){
        String result = find(resultTextLocator).getText();
        log.info("Result text: " + result);
        return result;
    }



}
