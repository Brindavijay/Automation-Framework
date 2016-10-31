package com.icon.steps;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Hooks {

    private static Logger logger = Logger.getLogger(Hooks.class);
    public static WebDriver driver;


    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
        System.out.println("Called openBrowser");
        System.setProperty("webdriver.chrome.driver", "/Users/a541351/Applications/workspaces/Brinda/Selenium-Workspace/chromedriver");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), capability);
        }catch(Exception e){
            logger.error("Not able to create Selenium Web Driver", e);
            e.printStackTrace();
            System.exit(1);

        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }


    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }
        driver.quit();

    }
}
