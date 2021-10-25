package com.soloodo.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features =  "src/main/java/com/soloodo/feature",
        tags = "@AddCompany",
        glue = "com/soloodo/stepdefinitions",
        plugin = {"html:target/cucumber-reports.html"}
)
public class Runner extends AbstractTestNGCucumberTests
{
    @DataProvider
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}
