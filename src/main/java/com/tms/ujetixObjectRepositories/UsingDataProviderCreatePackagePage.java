package com.tms.ujetixObjectRepositories;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bouncycastle.jcajce.provider.digest.GOST3411.HashMac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UsingDataProviderCreatePackagePage 
{
	//initialization
	public UsingDataProviderCreatePackagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//business library
	public void createpackage(WebDriver driver, HashMap<String, String>map)
	{
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
	}
}
