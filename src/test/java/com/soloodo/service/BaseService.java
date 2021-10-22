package com.soloodo.service;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseService
{
    public static WebDriver driver;
    WebDriverWait wait;

    public void explicitWait(int time)
    {
        wait = new WebDriverWait(driver,time);
    }
    public WebElement findElementByXpath(String path)
    {
        WebElement element = driver.findElement(By.xpath(path));
        return element;
    }

    public Boolean validateIfElementIsDisplayed(WebElement element)
    {
        Boolean flag = false;
        explicitWait(10);
        wait.until(ExpectedConditions.visibilityOf(element));
        if(element.isDisplayed())
            flag = true;
        return flag;
    }

    public Boolean validateIfElementIsSelected(WebElement element)
    {
        Boolean flag = false;
        explicitWait(10);
        wait.until(ExpectedConditions.visibilityOf(element));
        if(element.isSelected())
            flag = true;
        return flag;
    }

    public void actionClick(WebElement element)
    {
        element.click();
    }

    public void enterValueInField(WebElement element, String value)
    {
        element.click();
        element.sendKeys(value);
    }

    public void implicitWait(int time)
    {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void pressEnter(WebElement element)
    {
        element.sendKeys(Keys.ENTER);
    }
}
