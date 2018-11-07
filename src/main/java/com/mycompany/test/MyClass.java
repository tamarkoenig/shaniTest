package com.mycompany.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyClass
{
        public static WebDriver driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);

        @BeforeClass
	    public static void openBrowser()
        {
        	System.setProperty("webdriver.chrome.driver", "C://Users/candidate/Downloads/chromedriver_win32/chromedriver.exe"); 
        	WebDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get("http://google.com");
        }	
	
        @AfterClass
	    public static void coseBrowser()
        {  
            driver.quit();
        }
}
