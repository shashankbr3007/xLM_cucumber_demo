package com.xlm.cucumberdemo.stepdefinitions;

import com.vimalselvam.cucumber.listener.Reporter;
import com.xlm.cucumberdemo.utility.Utility;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class globalsQA {

    WebDriver webDriver;

    @Given("^Open globasqa website$")
    public void demoqaWebsiteIsLaunched() {
        webDriver = Utility.loadDriver("http://www.globalsqa.com/demo-site/", "Firefox");
    }

    @When("^User Clicks on button$")
    public void userClicksOnButton() throws Throwable {
        webDriver.findElement(By.id("menu-item-1513")).click();
        Reporter.addStepLog("Button Click Successful");
        Reporter.addScreenCaptureFromPath(Utility.captureScreenshot(webDriver, "home"));
    }

    @Then("^website navigates to a screen header with content$")
    public void websiteNavigatesToAScreenHeaderWithContent() throws Throwable {

        String content = webDriver.findElement(By.id("post-1397")).getText();
        String[] contentArray = content.split("\n");
        Assert.assertEquals(contentArray[0], "FIELDS OF EXPERTISE");

        Reporter.addStepLog("Actual:" + contentArray[0] + "<br /> Expected : FIELDS OF EXPERTISE");
        Reporter.addScreenCaptureFromPath(Utility.captureScreenshot(webDriver, "home"));
    }


    @And("^close browser$")
    public void closeTheBrowser() {
        webDriver.close();
        Reporter.setTestRunnerOutput("Closing the Browser Successful" + "<br /><br /><br /><br />");
    }
}
