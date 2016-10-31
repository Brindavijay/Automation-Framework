package com.icon.steps;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

public class SeleniumWebSiteTest {


    private static Logger logger = Logger.getLogger(SeleniumWebSiteTest.class);

    public WebDriver driver;

    public SeleniumWebSiteTest()
    {
        driver = Hooks.driver;
    }
    @When("^I open iconitgroup.com website$")
    public void i_open_seleniumframework_website() throws Throwable
    { // Write code here that turns the phrase above into concrete actions
        driver.get("http://iconitgroup.com/");
    }
    @Then("^I validate title and URL$")
    public void i_print_title_and_URL() throws Throwable {
// Write code here that turns the phrase above into concrete actions
        assertEquals("Icon IT Group Home",driver.getTitle());
        assertEquals("http://iconitgroup.com/",driver.getCurrentUrl());
    }
}


