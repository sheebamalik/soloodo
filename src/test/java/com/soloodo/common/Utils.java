package com.soloodo.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Utils
{
    public Properties readConfigFile()
    {
        Properties prop = new Properties();

        try
        {
            File file = new File("src/test/resources/config.properties");
            InputStream is = new FileInputStream(file);
            prop.load(is);
        }
        catch (Exception e)
        {
            System.out.println("Config file not found");
        }

        return prop;
    }

    public void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException
    {
        File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        String date = formatter.format(currentDate.getTime()).replace( "/", "_");
        FileUtils.copyFile(source_file, new File("src/test/resources/ScreenShots/" + date + ".png"));
    }
}
