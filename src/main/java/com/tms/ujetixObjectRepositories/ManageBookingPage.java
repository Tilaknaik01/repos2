package com.tms.ujetixObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ManageBookingPage 
{
	
	public ManageBookingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//business libraries
	public void confirm_btnCLick(WebDriver driver, String Comments) 
	{
		driver.findElement(By.xpath("//span[text()='"+Comments+"']/../..//a[text()='Confirm']")).click();	
	}
	public void cancel_btnCLick(WebDriver driver, String Comments) 
	{
		driver.findElement(By.xpath("//span[text()='"+Comments+"']/../..//a[text()='Cancel']")).click();	
	}
	
}
