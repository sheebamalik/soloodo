package com.soloodo.stepdefinitions;

import com.soloodo.service.BaseService;
import com.soloodo.common.Utils;
import com.soloodo.assertion.CustomAssertion;
import com.soloodo.constant.Xpath;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;

import java.util.Properties;


public class Registration
{
    String lstname = "user"+ RandomStringUtils.randomNumeric(3);
    CustomAssertion assertion = new CustomAssertion();
    BaseService baseService = new BaseService();

    Utils utils = new Utils();

    WebElement element;

    /**
     * Background scenario
     */

    @Given("I am on soloodo homepage")
    public void validateHomepage()
    {
        element = baseService.findElementByXpath(Xpath.REGISTRATION_LINK);
        Boolean flag = baseService.validateIfElementIsDisplayed(element);
        if (flag == true)
        {
            assertion.assertTrue(true, "Assertion passed");
        }
        else
        {
            assertion.assertFalse(false, "Assertion failed");

        }
    }

    @When("I click on register link")
    public void clickOnRegisterLink()
    {
        element = baseService.findElementByXpath(Xpath.REGISTRATION_LINK);
        baseService.actionClick(element);
    }

    @Then("I should be navigated to registration page")
    public void navigationToRegistrationPage()
    {
        element = baseService.findElementByXpath(Xpath.REGISTER_FORM);
        Boolean flag = baseService.validateIfElementIsDisplayed(element);
        if (flag == true)
        {
            assertion.assertTrue(true, "Assertion passed");
        }
        else
        {
            System.out.println("User could not be navigated to Registration page");
            assertion.assertFalse(false, "Assertion failed");
        }
   }

    @When("I select shipper option")
    public void shipperOptionSelection()
    {
        element = baseService.findElementByXpath(Xpath.SHIPPER_BUTTON);
        Boolean flag = baseService.validateIfElementIsSelected(element);
        if (flag == false)
        {
            baseService.actionClick(element);
        }
    }

    @When("user selects country")
    public void user_selects_country()
    {
        element = baseService.findElementByXpath(Xpath.COUNTRY);
        baseService.enterValueInField(element, "Germany");
        baseService.pressEnter(element);
    }

    @And("I enter name")
    public void userEntersName()
    {
        element = baseService.findElementByXpath(Xpath.INPUT_FIELDS.replace("$1$","firstName"));
        WebElement element2 = baseService.findElementByXpath(Xpath.INPUT_FIELDS.replace("$1$","lastName"));
        baseService.enterValueInField(element, "test");
        baseService.enterValueInField(element2,lstname);
    }

    @And("I enter company")
    public void enterCompany()
    {
        element = baseService.findElementByXpath(Xpath.INPUT_FIELDS.replace("$1$","company"));
        baseService.enterValueInField(element,"soloodo");
    }

    @And("I enter phone Number")
    public void enterPhoneNumber()
    {
        String contact = RandomStringUtils.randomNumeric(10);
        element = baseService.findElementByXpath(Xpath.INPUT_FIELDS.replace("$1$","undefined-number"));
        baseService.enterValueInField(element,contact);
    }

    @And("I enter email address")
    public void enterEmailAddress()
    {
        String email = lstname+"@gmail.com";
        element = baseService.findElementByXpath(Xpath.INPUT_FIELDS.replace("$1$","email"));
        baseService.enterValueInField(element,email);
    }

    @And("I enter password")
    public void enterPassword()
    {
        Properties prop = utils.readConfigFile();
        String password = prop.getProperty("password");
        element = baseService.findElementByXpath(Xpath.INPUT_FIELDS.replace("$1$","password"));
        baseService.enterValueInField(element,password);
    }

    @And("I accept terms & conditions")
    public void acceptTermsConditions()
    {
        element = baseService.findElementByXpath(Xpath.TERMS_CHECKBOX);
        baseService.actionClick(element);
    }

    @And("I click on register button")
    public void clickRegisterButton()
    {
        element = baseService.findElementByXpath(Xpath.SUBMIT_BUTTON);
        baseService.actionClick(element);
    }

    @Then("I should be navigated to welcome page of shipper")
    public void navigationToShipperWelcome()
    {
        element = baseService.findElementByXpath(Xpath.SUCCESS_MSG);
        baseService.implicitWait(30);
        Boolean flag = baseService.validateIfElementIsDisplayed(element);
        if (flag == true)
        {
            assertion.assertTrue(true, "Assertion passed");
        }
        else
        {
            System.out.println("Registration was not successful");
            assertion.assertFalse(false, "Assertion failed");
        }
    }

    @When("I select carrier option")
    public void selectCarrierOption()
    {
        element = baseService.findElementByXpath(Xpath.CARRIER_BUTTON);
        Boolean flag = baseService.validateIfElementIsSelected(element);
        if (flag == false)
        {
            baseService.actionClick(element);
        }
    }

    @Then("user navigates to welcome page of carrier")
    public void navigationToCarrierWelcome()
    {
        element = baseService.findElementByXpath(Xpath.CARRIER_SUCCESS);
        baseService.implicitWait(30);
        Boolean flag = baseService.validateIfElementIsDisplayed(element);
        if (flag == true)
        {
            assertion.assertTrue(true, "Assertion passed");
        }
        else
        {
            System.out.println("Registration was not successful");
            assertion.assertFalse(false, "Assertion failed");
        }
    }
}
