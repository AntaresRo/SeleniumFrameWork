package com.herokuapp.theinternet;

import com.herokuapp.theinternet.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExceptionsTests extends BaseTest {

    String url = "https://practicetestautomation.com/practice-test-exceptions";



    @Test
    public void noSuchElementExceptionTest() {
        driver.get(url);

        WebElement addButtonElement = driver.findElement(By.id("add_btn"));
        addButtonElement.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement row2Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));

        Assert.assertTrue(row2Input.isDisplayed(), "Row 2 is not displayed");
    }

    @Test
    public void elementNotInteractableException() {
        driver.get(url);
        String textToSend = "test";
        WebElement addButtonElement = driver.findElement(By.id("add_btn"));
        addButtonElement.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement row2Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
        row2Input.sendKeys(textToSend);

        WebElement saveButton = driver.findElement(By.xpath("//div[@id='row2']/button[@name='Save']"));
        saveButton.click();
        WebElement confirmation = driver.findElement(By.id("confirmation"));
        Assert.assertTrue(confirmation.isDisplayed(), "Confirmation is not displayed");


    }
    @Test
    public void invalidElementStateException() {
        driver.get(url);
        String foodToSend = "sushi";
        WebElement editButton = driver.findElement(By.id("edit_btn"));
        editButton.click();

        WebElement inputField = driver.findElement(By.xpath("//div[@id='row1']/input"));
        inputField.clear();
        inputField.sendKeys(foodToSend);

        WebElement saveButton = driver.findElement(By.id("save_btn"));
        saveButton.click();

        Assert.assertTrue(inputField.getAttribute("value").contains(foodToSend), "Field does not contain appropriate button");
    }
    @Test
    public void staleElementReferenceException() {
        driver.get(url);
        WebElement instructions = driver.findElement(By.cssSelector("p#instructions"));
        WebElement addButton = driver.findElement(By.id("add_btn"));
        addButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("p#instructions"))));

    }

 }
