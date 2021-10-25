package com.soloodo.service;

import com.soloodo.common.Utils;
import com.soloodo.constant.Xpath;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Properties;

public class addCompanyService extends BaseService
{
    Utils utils = new Utils();
    Properties prop = utils.readConfigFile();
    BaseService baseService = new BaseService();

    public void enterAddress()
    {
        String addressLine1 = prop.getProperty("addressLine1");
        String city = prop.getProperty("cologne");
        String areaCode = prop.getProperty("areaCode");
        ArrayList<WebElement> elements = new ArrayList<WebElement>();
        String[] address = {Xpath.ADDRESS_INPUT.replace("$1$","Street"),
                Xpath.ADDRESS_INPUT.replace("$1$","City"),
                Xpath.ADDRESS_INPUT.replace("$1$", "code")};
        String[] values = {prop.getProperty("addressLine1"), prop.getProperty("city"),
                            prop.getProperty("areaCode")};

        for (int i=0; i<address.length; i++)
        {
            elements.add(baseService.findElementByXpath(address[i]));
        }

        for(int i=0; i<elements.size(); i++)
        {
            baseService.enterValueInField(elements.get(i),values[i]);
        }
    }
}
