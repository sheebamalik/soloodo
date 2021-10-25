package com.soloodo.stepdefinitions;

import com.soloodo.service.BaseService;
import com.soloodo.common.Utils;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.IOException;
import java.util.Properties;

public class Hooks
{
    Utils utils = new Utils();

    @Before
    public void beforeScenario()
    {
        Properties prop = utils.readConfigFile();
        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");
        if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "Webdrivers/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");

            BaseService.driver = new ChromeDriver(chromeOptions);
            BaseService.driver.get(url);
        }

    }

    @After
    public void afterScenario() throws IOException
    {
        utils.takeScreenshotAtEndOfTest(BaseService.driver);
        BaseService.driver.close();
    }
}

