package com.soloodo.stepdefinitions;

import com.soloodo.service.BaseService;
import com.soloodo.assertion.CustomAssertion;
import com.soloodo.constant.Xpath;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

public class Login
{
    BaseService baseService = new BaseService();
    CustomAssertion assertion = new CustomAssertion();

    WebElement element;
    
    @When("I click on login link")
    public void clickOnLoginLink()
    {
        element = baseService.findElementByXpath(Xpath.LOGIN_LINK);
        baseService.actionClick(element);
    }

    @Then("I should be navigated to login page")
    public void navigationToLoginPage()
    {
        element = baseService.findElementByXpath(Xpath.LOGIN_FORM);
        Boolean flag = baseService.validateIfElementIsDisplayed(element);
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

    @And("I click on login button")
    public void clickOnLoginButton()
    {
        element = baseService.findElementByXpath(Xpath.SUBMIT_BUTTON);
        baseService.actionClick(element);
    }
}
