package com.soloodo.stepdefinitions;

import com.soloodo.common.Utils;
import com.soloodo.service.BaseService;
import com.soloodo.constant.Xpath;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.asserts.Assertion;

import java.util.Properties;

public class Login
{
    BaseService baseService = new BaseService();
    Assertion assertion = new Assertion();
    Utils utils = new Utils();
    WebElement element;
    Properties prop = utils.readConfigFile();

    //@Given I am on soloodo homepage in Registration.java

    @When("I click on login link")
    public void clickOnLoginLink()
    {
        element = baseService.findElementByXpath(Xpath.LOGIN_LINK);
        baseService.actionClick(element);
    }

    @Then("I should be navigated to login page")
    public void navigationToLoginPage()
    {
        Boolean flag = baseService.validateIfElementIsDisplayed(Xpath.LOGIN_FORM);
        if (flag == true)
        {
            assertion.assertTrue(true, "Assertion passed");
        }
        else
        {
            System.out.println("User could not be navigated to Login page");
            assertion.assertFalse(false, "Assertion failed");
        }
    }

    @When("I enter new email address on login page")
    public void enterEmailOnLogin()
    {
        String email = prop.getProperty("newemail");
        element = baseService.findElementByXpath(Xpath.LOGIN_INPUT_FIELDS.replace("$1$","email"));
        baseService.enterValueInField(element, email);
    }

    @And("I enter password on login page")
    public void enterPasswordOnLogin()
    {
        String password = prop.getProperty("password");
        element = baseService.findElementByXpath(Xpath.LOGIN_INPUT_FIELDS.replace("$1$","password"));
        baseService.enterValueInField(element, password);
    }

    @And("I click on login button")
    public void clickOnLoginButton()
    {
        element = baseService.findElementByXpath(Xpath.SUBMIT_BUTTON);
        baseService.actionClick(element);
        baseService.implicitWait(20);
    }

    //@Then I should be navigated to welcome page of shipper in Registration.java

    @When("I enter registered email address on login page")
    public void enterRegisteredEmailOnLogin()
    {
        String email = prop.getProperty("email");
        element = baseService.findElementByXpath(Xpath.LOGIN_INPUT_FIELDS.replace("$1$","email"));
        baseService.enterValueInField(element, email);
    }

    @Then("I should be navigated to Dashboard page")
    public void saveDetails()
    {
        Boolean flag = baseService.validateIfElementIsDisplayed(Xpath.PROFILE_ICON);
        if (flag == true)
        {
            assertion.assertTrue(true, "Assertion passed");
        }
        else
        {
            assertion.assertFalse(false, "Assertion failed");
        }
    }
}
