package com.xlm.cucumberdemo.runner;


import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.xlm.cucumberdemo.utility.Utility;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = {"./src/main/resources/features/globalsqa.feature"},
        glue = {"com.xlm.cucumberdemo.stepdefinitions"},
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:Reports/report.html"})

public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setup() throws Exception {
        Utility.loadProperty();
        System.setProperty("webdriver.gecko.driver", "./webdriver/geckodriverv0.19.1/geckodriver.exe");
        System.setProperty("java.awt.headless", "false");
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setKlovServerUrl("http://localhost:8181");
        extentProperties.setKlovProjectName("MyProject");
        extentProperties.setKlovReportName("TestReport");
        extentProperties.setMongodbHost("localhost");
        extentProperties.setMongodbPort(27017);
        extentProperties.setMongodbDatabase("klov");
        extentProperties.setReportPath("./Reports/Extentreport.html");
    }
}
