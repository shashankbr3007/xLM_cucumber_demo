package com.xlm.cucumberdemo.stepdefinitions;


import com.vimalselvam.cucumber.listener.Reporter;
import com.xlm.cucumberdemo.model.DemoQAModel;
import com.xlm.cucumberdemo.utility.Utility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;

public class DemoQATestSteps {

    WebDriver webDriver;
    DemoQAModel model = new DemoQAModel();

    @Given("^DemoQA website is launched$")
    public void demoqaWebsiteIsLaunched() {
        webDriver = Utility.loadDriver("http://demoqa.com/", "Firefox");
        Assert.assertEquals(model.get_landingPageHeader(webDriver), "Home");
        Reporter.addStepLog("Demo Qa Website Launch Successful" + "<br />");
    }

    @And("^close the browser$")
    public void closeTheBrowser() {
        webDriver.close();
        Reporter.setTestRunnerOutput("Closing the Browser Successful" + "<br /><br /><br /><br />");
    }

    @When("^User Clicks on \"([^\"]*)\"$")
    public void userClicksOnButton(String buttonName) {

        model.click_btn(webDriver, model.getButtonElement(buttonName));
        Reporter.addStepLog("Button Clicked : " + buttonName + "<br />");
    }

    @Then("^User navigates to Screen with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userNavigatesToScreenWithAnd(String expectedHeader, String expectedContent) throws IOException, AWTException {
        String actualHeader = model.get_landingPageHeader(webDriver);
        Assert.assertEquals(actualHeader, expectedHeader);

        Reporter.addStepLog("Actual Header : " + actualHeader + " | Expected Header : " + expectedHeader + "<br />");

        String landingPageContent = model.get_landingPageContent(webDriver);
        String[] actuallandingPageContent = landingPageContent.split("\n");
        Assert.assertEquals(actuallandingPageContent[0], expectedContent);

        Reporter.addScreenCaptureFromPath(Utility.captureScreenshot(webDriver, expectedHeader));

        Reporter.addStepLog("Actual Page Content : " + actuallandingPageContent[0] + "<br />" + "Expected Page Content : " + expectedContent + "<br />");
    }
}
