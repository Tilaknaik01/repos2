package com.tms.ujetixObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyTOurHistoryPage
{
	public MyTOurHistoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void mytourlist(WebDriver driver, String Comments) 
	{
		driver.findElement(By.xpath("//td[.='"+Comments+"']/..//a[.='Cancel']")).click();
	}
}
