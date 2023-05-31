package com.tms.ujetixObjectRepositories;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ujetix.genericUtils.ExcelUtility;
import ujetix.genericUtils.JavaScriptUtility;
import ujetix.genericUtils.JavaUtillity;

public class CreatePackagePage
{WebDriver driver=null;
//declaration
@FindBy(id = "packagename")private WebElement packageName_textfield;
@FindBy(id = "packagetype")private WebElement packageType_textfield;
@FindBy(id = "packagelocation")private WebElement packageLocation_textfield;
@FindBy(id = "packageprice")private WebElement packagePrice_textfield;
@FindBy(id = "packagefeatures")private WebElement packageFeatures_textfield;
@FindBy(id = "packagedetails")private WebElement packageDetails_textfield;
@FindBy(id = "packageimage")private WebElement packageImage;
@FindBy(name = "submit")private WebElement submit_btn;
@FindBy(xpath = "//div[@class='succWrap']") private WebElement confirmatation;

//initialization
public CreatePackagePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


public WebElement getPackageName_textfield() {
	return packageName_textfield;
}


public WebElement getPackageType_textfield() {
	return packageType_textfield;
}


public WebElement getPackageLocation_textfield() {
	return packageLocation_textfield;
}


public WebElement getPackagePrice_textfield() {
	return packagePrice_textfield;
}


public WebElement getPackageFeatures_textfield() {
	return packageFeatures_textfield;
}


public WebElement getPackageDetails_textfield() {
	return packageDetails_textfield;
}


public WebElement getPackageImage() {
	return packageImage;
}


public WebElement getSubmit_btn() {
	return submit_btn;
}
public WebElement getConfirmatation() {
	return confirmatation;
}




//business libraries
public void createTourPakage(WebDriver driver,String packagename, String packagetype,String packageLocation, String packageprice, String packagefeature,String packagedetails, String packageimage)
{
	packageName_textfield.sendKeys(packagename);
	packageType_textfield.sendKeys(packagetype);
	packageLocation_textfield.sendKeys(packageLocation);
	packagePrice_textfield.sendKeys(packageprice);
	//sctoll till submit button
	JavaScriptUtility jsu= new JavaScriptUtility(driver);
	jsu.scrollDown();
	packageFeatures_textfield.sendKeys(packagefeature);
	packageDetails_textfield.sendKeys(packagedetails);
	packageImage.sendKeys(packageimage);
	submit_btn.click();	

}


//business library

public void createpackage(WebDriver driver) throws EncryptedDocumentException, IOException
{
	ExcelUtility eu=new ExcelUtility();
	JavaUtillity ju=new JavaUtillity();
	HashMap<String, String> map = eu.getmultipledata();
	for(Entry<String, String> set:map.entrySet())
	{

		if(set.getKey().equalsIgnoreCase("packagename"))
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+ju.getRandomNumber());

		}
		else if (set.getKey().equalsIgnoreCase("packagelocation"))
		{
			//scroll till submit button
			JavaScriptUtility jsu= new JavaScriptUtility(driver);
			jsu.scrollDown();
		}
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
	}
	submit_btn.click();	



}
}



