package com.bluesky.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Createdriver {
	
	public static WebDriver getDriverInterface()
	{
		WebDriver driver=null;
		String browser=DataHandlers.getDataFromProperties("./config-data/configuration.properties","browser");
		String url=DataHandlers.getDataFromProperties("./config-data/configuration.properties","url");
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette","C:\\Users\\MartandAbhishek76\\MyFirst_SeleniumProject\\Bluesky-Test\\browser-servers\\geckodriver.exe" );
			
			driver = new FirefoxDriver();			
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\MartandAbhishek76\\MyFirst_SeleniumProject\\Bluesky-Test\\browser-servers\\chromedriver.exe" );
			
			driver = new ChromeDriver();	
		}
		
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\MartandAbhishek76\\MyFirst_SeleniumProject\\Bluesky-Test\\browser-servers\\IEDriverServer.exe" );
			
			driver = new InternetExplorerDriver();	
		}
		else
		{
			System.err.println("-------------INVALID BROWSER OPTION-------------");
			return driver;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

}
