package com.bluesky.object.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getUsernameTextbox()
	{
		WebElement un=driver.findElement(By.name("username"));
		return un;
	}
	
	public WebElement getPasswordTextbox()
	{
		WebElement un=driver.findElement(By.name("pwd"));
		return un;
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(By.xpath("//input[@type='submit']"));
	
	}
	
	public WebElement getLoginErrorMsg()
	{
		return driver.findElement(By.xpath("//span[contains(text,'Password is invalid']"));
	
	}
	
	public void WaitLoginPageToLoad()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@align='center']"))));
	}
	

}
