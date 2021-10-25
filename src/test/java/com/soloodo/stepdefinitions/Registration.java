package com.soloodo.stepdefinitions;

import com.soloodo.service.BaseService;
import com.soloodo.common.Utils;
import com.soloodo.constant.Xpath;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.asserts.Assertion;

public class Registration
{
    String lstname = "user"+ RandomStringUtils.randomNumeric(3);
    Assertion assertion = new Assertion();
    BaseService baseService = new BaseService();

    Utils utils = new Utils();

    WebElement element;

    @Given("I am on soloodo homepage")
    public void validateHomepage()
    {
        Boolean flag = baseService.validateIfElementIsDisplayed(Xpath.REGISTRATION_LINK);
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
        Boolean flag = baseService.validateIfElementIsDisplayed(Xpath.REGISTER_FORM);
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

    @When("I select country")
    public void selectCountry()
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

    @And("^I enter email \"(.*)\"$")
    public void enterEmailOnReg(String email)
    {
        element = baseService.findElementByXpath(Xpath.INPUT_FIELDS.replace("$1$","email"));
        baseService.enterValueInField(element,email);
    }

    @And("^I enter password \"(.*)\"$")
    public void enterPasswordOnReg(String password)
    {
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
        baseService.implicitWait(30);
        Boolean flag = baseService.validateIfElementIsDisplayed(Xpath.SUCCESS_MSG);
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
        Boolean flag = baseService.validateIfElementIsSelected(Xpath.CARRIER_BUTTON);
        if (flag == false)
        {
            element = baseService.findElementByXpath(Xpath.SHIPPER_BUTTON);
            baseService.actionClick(element);
        }
    }

    @Then("I should be navigated to welcome page of carrier")
    public void navigationToCarrierWelcome()
    {
        baseService.implicitWait(30);
        Boolean flag = baseService.validateIfElementIsDisplayed(Xpath.CARRIER_SUCCESS);
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
