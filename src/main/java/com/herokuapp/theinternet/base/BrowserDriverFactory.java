package com.herokuapp.theinternet.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final String browser;
    private final Logger log;

    public BrowserDriverFactory(String browser, Logger log) {

        this.browser = browser;
        this.log = log;
    }


    public WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        log.info("Create driver: " + browser);
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver.set(new ChromeDriver(options));
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver.set(new FirefoxDriver());
                break;

            default:
                System.out.println("No valid browser selected, using default Chrome");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver.set(new ChromeDriver(options));
                break;

        }
        return driver.get();
    }
}