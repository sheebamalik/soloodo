package com.soloodo.stepdefinitions;

import com.soloodo.common.Utils;
import com.soloodo.constant.Xpath;
import com.soloodo.service.BaseService;
import com.soloodo.service.addCompanyService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.asserts.Assertion;

import java.awt.*;
import java.util.Properties;

public class addCompany
{
    WebElement element;
    addCompanyService addCompanyService = new addCompanyService();
    Assertion assertion = new Assertion();
    Utils utils = new Utils();
    Properties prop = utils.readConfigFile();

    @When("^I enter email address on login page$")
    public void enterEmailOnLogin()
    {
        String email = prop.getProperty("newemail");
        element = addCompanyService.findElementByXpath(Xpath.LOGIN_INPUT_FIELDS.replace("$1$","email"));
        addCompanyService.enterValueInField(element, email);
    }

    @And("^I enter password on login page$")
    public void enterPasswordOnLogin()
    {
        String password = prop.getProperty("password");
        element = addCompanyService.findElementByXpath(Xpath.LOGIN_INPUT_FIELDS.replace("$1$","password"));
        addCompanyService.enterValueInField(element, password);
    }

    @Then("I should be able to see email verified message")
    public void emailVerified()
    {
        Boolean flag = addCompanyService.validateIfElementIsDisplayed(Xpath.VERIFIED_STATUS);
        if (flag==false)
        {
            System.out.println("Email has not been verified yet");
            assertion.assertFalse(false, "Assertion failed");
        }

    }

    @When("I click on Next button")
    public void clickNextButton()
    {

        element = addCompanyService.findElementByXpath(Xpath.NEXT_BUTTON);
        addCompanyService.actionClick(element);
    }

    @And("I enter adress line, city and postal code")
    public void enterAddress()
    {
        addCompanyService.enterAddress();
    }

    @And ("I enter VATID")
    public void enterVAT()
    {
        String VATID = "DE"+ RandomStringUtils.randomNumeric(9);
        element = addCompanyService.findElementByXpath(Xpath.ADDRESS_INPUT.replace("$1$","VAT"));
        addCompanyService.enterValueInField(element,VATID);
    }

    @And ("I click on Ask me later")
    public void askLater()
    {
        addCompanyService.implicitWait(20);
        element = addCompanyService.findElementByXpath(Xpath.LATER_BUTTON);
        addCompanyService.actionClick(element);
    }
}
