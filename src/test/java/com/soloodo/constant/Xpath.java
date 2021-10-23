package com.soloodo.constant;

public class Xpath
{
    //Elements of soloodo homepage
    public static String REGISTRATION_LINK = "//a[text()='Register']";
    public static String LOGIN_LINK = "//a[text()='Login']";

    //Elements of registration page
    public static String REGISTER_FORM = "//*[@data-testid='registerForm']";
    public static String SHIPPER_BUTTON = "//*[contains(text(),'I am a shipper')]";
    public static String CARRIER_BUTTON = "//*[contains(text(),'I am a carrier')]";
    public static String COUNTRY = "//input[@id='country']";
    public static String INPUT_FIELDS = "//input[@name = '$1$']";
    public static String TERMS_CHECKBOX = "//input[@name = 'isTermsAndConditionsAccepted']/preceding-sibling::span";
    public static String SUBMIT_BUTTON = "//button[@data-testid = 'PrimaryButton']";
    public static String SUCCESS_MSG = "//div[text()='Verify your email address']";
    public static String CARRIER_SUCCESS = "//div[@id='intercom-container']";

    //Elemets of login page
    public static String LOGIN_FORM="//*[@data-testid='loginForm']";

}
