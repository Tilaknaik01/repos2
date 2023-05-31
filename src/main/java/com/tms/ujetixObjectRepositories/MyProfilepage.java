package com.tms.ujetixObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ujetix.genericUtils.JavaScriptUtility;

public class MyProfilepage 
{
	//declaration
	@FindBy(id = "name")private WebElement nametext;
	@FindBy(id = "mobileno")private WebElement mobileno;
	@FindBy(name = "submit6")private WebElement submit_btn;
	@FindBy(xpath = "//strong[.='SUCCESS']") private WebElement confirm_text;
	
	
	//init
	
	public MyProfilepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getNametext() {
		return nametext;
	}

	public WebElement getMobileno() {
		return mobileno;
	}

	public WebElement getSubmit_btn() {
		return submit_btn;
	}

	public WebElement getConfirm_text() {
		return confirm_text;
	}

	//util
	public void update(WebDriver driver, String updated_mblno) 
	{
		mobileno.sendKeys(Keys.CONTROL+"a");
		mobileno.sendKeys(Keys.DELETE);
		mobileno.sendKeys(updated_mblno);
		JavaScriptUtility jsu = new JavaScriptUtility(driver);
		jsu.scrollDown();
		submit_btn.click();
		
	}

}
