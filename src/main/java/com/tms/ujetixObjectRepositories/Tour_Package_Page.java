package com.tms.ujetixObjectRepositories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v110.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ujetix.genericUtils.ExcelUtility;

public class Tour_Package_Page
{
	public Tour_Package_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//business library
	public void clickOnDetails(WebDriver driver, String package_Name) 
	{
		WebElement details = driver.findElement(By.xpath("//h4[contains(.,'"+package_Name+"')]/../..//a[.='Details']"));
		details.click();
	}

	public boolean packageNameIsPresentOrNot(WebDriver driver, String Package_Name) 
	{
		try 
		{
			driver.findElement(By.xpath("//h4[contains(text(),'"+Package_Name +"')]"));
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
